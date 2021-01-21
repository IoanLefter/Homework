package com.homework.homework16.ex1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String INPUT_TXT = "input.txt";
        final String OUTPUT_TXT = "output.txt";

        System.out.println("dgf");

        extractWords(INPUT_TXT);

        System.out.println();

        printAndExportMap(sortDescByValueAskByKey(uniqueWordCount(INPUT_TXT)), OUTPUT_TXT);

    }

    public static List<String> extractWords(String INPUT_TXT) {
        List<String> tokens = new ArrayList<>();

        StringBuilder text = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new FileReader(INPUT_TXT))) {

            String line;

            while ((line = in.readLine()) != null) {
                text.insert(0, line.replaceAll("([\\[\\],.?!():'-])", " $1 "));
            }

            tokens = Arrays.asList(text.toString().split("\\s"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tokens;
    }


    public static Map<String, Integer> uniqueWordCount(String INPUT_TXT) {
        HashMap<String, Integer> uniqueWordCount = new HashMap<>();
        List<String> tokens = extractWords(INPUT_TXT);
        for (String token : tokens) {
            int frequency = Collections.frequency(tokens, token);
            uniqueWordCount.put(token, frequency);
        }
        return uniqueWordCount;
    }


    private static Map<String, Integer> sortDescByValueAskByKey(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        list.sort((o1, o2) -> (-1 * (o1.getValue()).compareTo(o2.getValue()) != 0) ? -1 * (o1.getValue()).compareTo(o2.getValue()) : o1.getKey().compareTo(o2.getKey()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


    public static <K, V> void printAndExportMap(Map<K, V> map, String OUTPUT_TXT) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(OUTPUT_TXT))) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                System.out.println(entry.getValue() + " : " + entry.getKey());
                out.write(entry.getValue() + " : " + entry.getKey() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
