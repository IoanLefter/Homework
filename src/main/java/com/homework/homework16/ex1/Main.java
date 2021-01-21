package com.homework.homework16.ex1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final String INPUT_TXT = "input.txt";
        final String OUTPUT_TXT = "output.txt";

        System.out.println("dgf");

        extractWords(INPUT_TXT);

        printAndExportMap(sortDescByValue(uniqueWordCount(INPUT_TXT)), OUTPUT_TXT);

    }

    public static List<String> extractWords(String INPUT_TXT) {
        List<String> tokens = null;
        try (
                Scanner sc = new Scanner(new FileInputStream(INPUT_TXT))) {
            tokens = sc.tokens()
                    .collect(Collectors.toList());

        } catch (
                IOException e) {
            e.printStackTrace();
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


    private static Map<String, Integer> sortDescByValue(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, (o1, o2) -> -1 * (o1.getValue()).compareTo(o2.getValue()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


    public static <K, V> void printAndExportMap(Map<K, V> map, String OUTPUT_TXT) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(OUTPUT_TXT));) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                System.out.println(entry.getValue() + " : " + entry.getKey());
                out.write(entry.getValue() + " : " + entry.getKey() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
