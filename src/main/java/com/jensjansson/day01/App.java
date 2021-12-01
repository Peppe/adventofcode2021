package com.jensjansson.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello day 1!");
        new App();
    }

    public App() {
        List<String> lines = readInput();
        calculateIncreases(lines);
        calculateSlidingWindow(lines);
    }

    private List<String> readInput() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("input.txt").getPath()));
            return lines;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;

    }

    private void calculateIncreases(List<String> lines) {
        int increases = 0, decreases = 0, noChange = 0;
        int lastMeasurement = -1;
        for (String line : lines) {
            int currentMeasurement = Integer.parseInt(line);
            if (lastMeasurement == -1) {
            } else if (currentMeasurement > lastMeasurement) {
                increases++;
            } else if (currentMeasurement == lastMeasurement) {
                noChange++;
            } else {
                decreases++;
            }
            lastMeasurement = currentMeasurement;
        }
        System.out.println("Final. Increases: " + increases + ", decreases: " + decreases + ", noChange: " + noChange);
    }

    private void calculateSlidingWindow(List<String> lines) {
        int increases = 0, decreases = 0, noChange = 0;
        int lastSum = -1;
        int lastMeasurement1 = -1, lastMeasurement2 = -1, lastMeasurement3 = -1;
        for (String line : lines) {
            int currentMeasurement = Integer.parseInt(line);
            lastMeasurement3 = lastMeasurement2;
            lastMeasurement2 = lastMeasurement1;
            lastMeasurement1 = currentMeasurement;
            int newSum = -1;
            if(lastMeasurement3 != -1 ){
                newSum = lastMeasurement3 + lastMeasurement2 + lastMeasurement1;
            }
            if (lastSum == -1 ) {
            } else if (newSum > lastSum) {
                increases++;
            } else if (newSum == lastSum) {
                noChange++;
            } else {
                decreases++;
            }
            lastSum = newSum;
        }
        System.out.println("Final. Increases: " + increases + ", decreases: " + decreases + ", noChange: " + noChange);
    }

}
