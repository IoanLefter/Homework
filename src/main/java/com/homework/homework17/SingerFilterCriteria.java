package com.homework.homework17;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static com.homework.homework17.Crud.getAllSingersQuery;

public class SingerFilterCriteria {
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


    public static void main(String[] args) {
        System.out.println("singers named John:");
        singerFilter("John",null,null,null).forEach(System.out::println);
        System.out.println();
        System.out.println("singers named John Lennon:");
        singerFilter("John","Lennon",null,null).forEach(System.out::println);
        System.out.println();
        System.out.println("all singers:");
        singerFilter(null,null,null,null).forEach(System.out::println);
        System.out.println();
        System.out.println("Singers on album The Beatles:");
        singerFilter(null,null,null,"The Beatles").forEach(System.out::println);
        System.out.println();
        System.out.println("Singers born on 1941-11-24:");
        singerFilter(null,null, LocalDate.of(1941, 11, 24).toString(),null).forEach(System.out::println);



    }

    public static List<Singer> singerFilter(String firstName, String lastName, String birthDate, String albumName){
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        StringJoiner where = new StringJoiner(" AND ", " WHERE ", "").setEmptyValue("");
        if (firstName != null)
            where.add("firstName = :firstName");
        if (lastName != null)
            where.add("lastName = :lastName");
        if (birthDate != null)
            where.add("birthDate = :birthDate");
        if (albumName != null)
            where.add("name = :name");
        String sql = getAllSingersQuery + where;

        Map<String, Object> params = new HashMap<>();
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("birthDate", birthDate);
        params.put("name", albumName);

        return jdbcTemplate.query(sql, params, Crud::mapRowToSinger);
    }
}
