package com.jensjansson.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {

    public static void main(String[] args) {
        new App();
    }

    public App() {
        List<String> lines = readInput();
        calculatePosition(lines);
        calculatePositionWithAim(lines);
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

    private void calculatePosition(List<String> lines) {
        int horizontal = 0, depth = 0;
        for(String line : lines){
            String[] parts = line.split(" ");
            int value = Integer.parseInt(parts[1]);
            switch(parts[0]){
                case "forward":
                    horizontal += value;
                    break;
                case "up":
                    depth -= value;
                    break;
                case "down":
                    depth += value;
                    break;
                default:
            }
            // System.out.println("Command: " + line + " - Position now, horizontal:" + horizontal + ", depth: " + depth);
        }
        System.out.println("Final answer - horizontal:" + horizontal + ", depth: " + depth +", multiplication: " + horizontal*depth);
    }

    private void calculatePositionWithAim(List<String> lines) {
        int horizontal = 0, depth = 0, aim = 0;
        for(String line : lines){
            String[] parts = line.split(" ");
            int value = Integer.parseInt(parts[1]);
            switch(parts[0]){
                case "forward":
                    horizontal += value;
                    depth += aim*value;
                    break;
                case "up":
                    aim -= value;
                    break;
                case "down":
                    aim += value;
                    break;
                default:
            }
            System.out.println("Command: " + line + " - Position now, horizontal:" + horizontal + ", depth: " + depth + ", aim: " + aim);
        }
        System.out.println("Final answer - horizontal:" + horizontal + ", depth: " + depth +", multiplication: " + horizontal*depth);
    }
}
