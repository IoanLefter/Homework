package com.homework.instagram;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractUsers {
    public static void main(String[] args) throws IOException {
        List<String> followers= new ArrayList<>();
        followers.addAll(extractUsers("src/main/java/com/homework/instagram/followers.txt"));
        //followers.stream().forEach(System.out::println);

        List<String> following= new ArrayList<>();
        following.addAll(extractUsers("src/main/java/com/homework/instagram/following.txt"));
        following.stream().forEach(System.out::println);

        //list of users that are not followers
        List<String> differences = new ArrayList<>(following);
        differences.removeAll(followers);
        //differences.stream().forEach(System.out::println);
    }
    public static List<String>  extractUsers(String filePath) throws FileNotFoundException, IOException {

        List<String> lineList = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        String line;
        while ((line = br.readLine()) != null) {
            String pattern = "([^>]*)(<\\/a><\\/span>)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            while (m.find()) {
                lineList.add(m.group(1));
            }
        }
        return lineList;
    }

}