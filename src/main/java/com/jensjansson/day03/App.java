package com.jensjansson.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {
        new App();
    }

    public App() throws IOException {
        List<String> lines = readInput();
        calculatePower(lines);
        calculateOxygen(lines);
    }

    private List<String> readInput() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("input.txt").getPath()));
        return lines;
    }

    private void calculatePower(List<String> lines) {
        
        int count = lines.size();
        int[] ones = calculateOnes(lines);
        System.out.println(Arrays.toString(ones));
        System.out.println(count);
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for(int number : ones){
            if(number > (count/2)){
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        System.out.println(gamma);
        System.out.println(epsilon);
        int gammaInt = getIntFromBinary(gamma.toString());
        int epsilonInt = getIntFromBinary(epsilon.toString());
        System.out.println("gamma: " + gammaInt + ", epsilon: " + epsilonInt + ", power: " + (gammaInt*epsilonInt));
    }

    private int[] calculateOnes(List<String> lines){
        int[] ones = new int[12];
        for (String line : lines) {
            int lettercount = 0;
            for(String letter : line.split("")){
                if(!("1".equals(letter) || "0".equals(letter))) {
                    System.out.println("Invalid letter: " +letter);
                }
                if(lettercount>11){
                    System.out.println("Invalid letter count: " + (lettercount+1) + " letters");
                }
                if("1".equals(letter)) {
                    ones[lettercount]++;
                }
                lettercount++;
            }
            System.out.println(Arrays.toString(ones));
        }
        return ones;
    }

    private void calculateOxygen(List<String> lines){
            
            
        List<String> oxygenLines = lines;
        List<String> co2Lines = lines;
        
        for(int i = 0; i < 12; i++){
            int[] ones = calculateOnes(oxygenLines);
            final char target = ones[i]*2 >= oxygenLines.size() ? '1' : '0';
            final int finalI = i;
            oxygenLines = oxygenLines.stream().filter(oneString -> oneString.charAt(finalI) == target).collect(Collectors.toList());
            if(oxygenLines.size() <= 1){
                break;
            }
        }
        String oxygen = oxygenLines.get(0);

        for(int i = 0; i < 12; i++){
            int[] ones = calculateOnes(co2Lines);
            final char target = ones[i]*2 >= co2Lines.size() ? '0' : '1';
            final int finalI = i;
            co2Lines = co2Lines.stream().filter(oneString -> oneString.charAt(finalI) == target).collect(Collectors.toList());
            System.out.println("co2lines: " + co2Lines.size() + ", index: " + i);
            if(co2Lines.size() <= 1){
                break;
            }
        }
        System.out.println(oxygenLines.size() + " " + co2Lines.size());
        String co2 = co2Lines.get(0);

        
        
        System.out.println("oxygen: " + oxygen);
        System.out.println("co2: " + co2);
        int oxygenInt = getIntFromBinary(oxygen);
        int co2Int = getIntFromBinary(co2);
        System.out.println("oxygen: " + oxygenInt + ", co2: " + co2Int + ", lifesupport:" + (oxygenInt*co2Int));
    }

    private int getIntFromBinary(String binary){
        return Integer.parseInt(binary, 2);   
    }
}
