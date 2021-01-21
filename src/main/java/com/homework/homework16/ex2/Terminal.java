package com.homework.homework16.ex2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {

        startTerminal();

    }

    public static void startTerminal() {
        Scanner in = new Scanner(System.in);
        String input = "";
        help();

        try {
            while (!input.equalsIgnoreCase("exit")) {
                input = in.next();
                switch (input) {
                    case "exit":
                        System.out.println("You have exited the terminal.");
                        return;
                    case "help":
                        help();
                        break;
                    case "dir":
                        dir();
                        break;
                    case "parent":
                        parent();
                        break;
                    case "cd":
                        cd(in.next());
                        break;
                    case "search":
                        searchInDirectorAndSubDir(in.next());
                        break;
                    case "root":
                        root();
                        break;
                    case "new":
                        newFileOrFolder(in.next());
                        break;
                    default:
                        System.out.println("Please use a valid command!");
                        help();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void help() {
        System.out.println();
        System.out.println("Available commands: \n" +
                "[help] - display help menu \n" +
                "[dir] - displays the content of the current directory \n" +
                "[parent] -  go to parent folder \n" +
                "[cd path] - change directory \n" +
                "[search] - it will search for an item in current dir and all sub dir \n" +
                "[root] - go to root \n" +
                "[new file.extension] - create a new file \n" +
                "[new foldername] - create a new folder \n" +
                "[exit] - to exit the terminal");
        System.out.println(PathsOS.inputPath);

    }

    public static void dir() throws IOException {
        Path p = Paths.get(PathsOS.inputPath);
        Files.list(p)
                .map(Path::getFileName)
                .forEach(System.out::println);
        System.out.println(PathsOS.inputPath);

    }

    public static void parent() {
        Path p = Paths.get(PathsOS.inputPath);
        PathsOS.inputPath = p.getParent().toString();
        System.out.println(PathsOS.inputPath);

    }

    public static void cd(String item) {
        Path p = Paths.get(PathsOS.inputPath);
        PathsOS.inputPath = p.resolve(item).toString();
        System.out.println(PathsOS.inputPath);
    }

    public static void root() {
        Path p = Paths.get(PathsOS.inputPath);
        PathsOS.inputPath = p.getRoot().toString();
        System.out.println(PathsOS.inputPath);
    }


    public static void searchInDirectorAndSubDir(String item) throws IOException {
        Path p = Paths.get(PathsOS.inputPath);
        Files.walk(p)
                .filter(filename -> filename.getFileName().toString().toLowerCase().startsWith(item))
                .forEach(System.out::println);
        System.out.println(PathsOS.inputPath);
    }

    public static void newFileOrFolder(String item) throws IOException {
        Path p = Paths.get(PathsOS.inputPath);

        if (item.contains(".")) {
            Files.createFile(p.resolve(item));
            dir();
            return;
        } else {
            File theDir = new File(String.valueOf(p.resolve(item)));
            if (!theDir.exists()) {
                theDir.mkdirs();
                dir();
            }
        }


    }

}
