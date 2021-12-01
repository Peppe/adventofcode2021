package com.jensjansson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    String[] input;
    private List<String> lines;

    public static void main(String[] args) {
        System.out.println("Hello day 1!");
        new App();
    }

    public App() {
        readInput();
    }

    private void readInput() {
        try {
            lines = Files.readAllLines(Paths.get(getClass().getResource("input.txt").getPath()));
            System.out.println(lines);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void readInputLineByLine() {

        InputStream fis = getClass().getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String row;
        try {
            while ((row = br.readLine()) != null) {
                System.out.println(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
