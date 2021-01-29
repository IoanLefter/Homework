package com.homework.homework17;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Crud {

    private static final DriverManagerDataSource dataSource;

    private static final JdbcTemplate jdbcTemplate;

    static {
        dataSource = new DriverManagerDataSource();
        dataSource.setPassword("secret-pass");
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost:3321/spotify?useSsl=true&serverTimezone=EET");
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }


    public static void main(String... args) {
        //Create singers
        insertSinger("John", "Lennon", LocalDate.of(1940, 10, 9).toString());
        insertSinger("Ringo", "Starr", LocalDate.of(1940, 7, 7).toString());
        insertSinger("Pete", "Best", LocalDate.of(1941, 11, 24).toString());
        insertSinger("Elvis", "Presley", LocalDate.of(1935, 1, 8).toString());
        insertSinger("Michael", "Jackson", LocalDate.of(1958, 8, 29).toString());
        insertSinger("John", "Doe", LocalDate.of(1940, 10, 9).toString());
        insertSinger("John", "Newman", LocalDate.of(1940, 10, 9).toString());

        //Create albums only if they are assigned to an existing singer
        insertAlbum(1L, "The Beatles", LocalDate.of(1968, 1, 1).toString(), "Beatles album");
        insertAlbum(1750L, "The Beatles", LocalDate.of(1968, 1, 1).toString(), "Beatles album");

        //Read
        getSingersWithAlbums();
        System.out.println();
        System.out.println("print all singers");
        getAllSingers().forEach(System.out::println);

        //Update
        updateSingersLastName("Smith", "Doe", "John");

        //Delete (delete last inserted record)
        deleteLastInsertedSinger();
    }


    public static String insertSingersQuery = "INSERT INTO spotify.singer (" +
            "firstName, " +
            "lastName, " +
            "birthDate) " +
            "VALUES (" +
            "?,?,?);";

    public static void insertSinger(String firstName, String lastName, String birthDay) {
        int updatedRows = jdbcTemplate.update(insertSingersQuery, firstName, lastName, birthDay);
        if (updatedRows == 0) {
            System.out.println("Bad insert for " + firstName + " " + lastName);
        } else {
            System.out.println("Singer " + firstName + " " + lastName + " inserted successfully");
        }
    }

    public static void insertAlbum(Long singerId, String name, String releaseDate, String description) {
        try {
            List<Singer> allSingers = getAllSingers();
            for (Singer singer : allSingers) {
                if (singer.getId() == singerId) {
                    jdbcTemplate.update("INSERT INTO spotify.album (singerId, name, releaseDate, description) VALUES (?,?,?,?);", singerId, name, releaseDate, description);
                    System.out.println("The insert of album " + name + " is successful.");
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println("Bad insert " + e);
        }

        System.out.println("The singer ID " + singerId + " is not in DB.");
    }

    public static String getSingersWithAlbumsQuery = "SELECT s.id as sid, \n" +
            "       lastName,\n" +
            "       firstName,\n" +
            "       birthDate,\n" +
            "       a.id as aid,\n" +
            "       singerId,\n" +
            "       name,\n" +
            "       releaseDate,\n" +
            "       description" +
            " FROM singer s" +
            " JOIN album a on s.id = a.singerId;";

    public static String getAllSingersQuery = "SELECT s.id as sid, \n" +
            "       lastName,\n" +
            "       firstName,\n" +
            "       birthDate,\n" +
            "       a.id as aid,\n" +
            "       singerId,\n" +
            "       name,\n" +
            "       releaseDate,\n" +
            "       description" +
            " FROM singer s" +
            " LEFT JOIN album a on s.id = a.singerId ";

    public static void getSingersWithAlbums() {
        List<Singer> singersWithAlbumsList = jdbcTemplate.query(getSingersWithAlbumsQuery,
                Crud::mapRowToSinger);
        System.out.println();
        System.out.println("Read only singers with albums");
        singersWithAlbumsList.forEach(System.out::println);
        System.out.println();
    }

    public static List<Singer> getAllSingers() {
        return jdbcTemplate.query(getAllSingersQuery, Crud::mapRowToSinger);
    }

    static Singer mapRowToSinger(ResultSet rs, int rowNumber) throws SQLException {
        Singer singer = Singer.builder()
                .id(rs.getLong("sid"))
                .lastName(rs.getString("lastName"))
                .firstName(rs.getString("firstName"))
                .birthDate(rs.getDate("birthDate").toLocalDate())
                .build();

        if (rs.getLong("aid") != 0) {
            Album album = Album.builder()
                    .id(rs.getLong("aid"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .releaseDate(rs.getDate("releaseDate").toLocalDate())
                    .build();
            singer.setAlbum(album);
        }
        return singer;
    }

    public static String updateSingersLastNameQuery = "UPDATE spotify.singer SET " +
            "lastName=?  " +
            "WHERE lastName=?  " +
            "AND firstName=?;";

    public static void updateSingersLastName(String newLastName, String oldLastName, String oldFirstName) {
        int updatedRows = jdbcTemplate.update(updateSingersLastNameQuery, newLastName, oldLastName, oldFirstName);
        if (updatedRows == 0) {
            System.out.println("Name " + oldLastName + " " + oldFirstName + " is not in DB");
        } else {
            System.out.println("Singer " + oldLastName + " " + oldFirstName + " updated successfully with new last name: " + newLastName);
        }
    }


    public static void deleteLastInsertedSinger() {
        try {

            List<Long> id = jdbcTemplate.query("select max(id) from spotify.singer;", Crud::maxID);
            Long idx = id.get(0);
            jdbcTemplate.update("delete from spotify.singer where id=?;", idx);

        } catch (Exception e) {
            System.out.println("Bad delete " + e);
        }
    }

    private static Long maxID(ResultSet rs, int rowNum) throws SQLException {
        return rs.getLong(1);
    }
}