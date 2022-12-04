package AoC22.day3;

import java.io.*;
import java.util.*;

public class day3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day3/input"));
        int prioSum = 0;

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String line;
        while ((line = br.readLine()) != null) {
            // for (String line : testdata.split("\n")) {
            int[] charValues = new int[line.length()];
            int i = 0;
            for (String e : line.split("")) {
                charValues[i] = (alphabet.indexOf(e))+1;
                i++;
            }

            int[] firstComp = Arrays.copyOfRange(charValues, 0, charValues.length / 2);
            int[] secondComp = Arrays.copyOfRange(charValues, charValues.length / 2, charValues.length);

            Set<Integer> priorities = new HashSet<>();
            for (int k = 0; k < firstComp.length; k++) {
                for (int j = 0; j < secondComp.length; j++) {
                    if (firstComp[k] == secondComp[j]) {
                        priorities.add(firstComp[k]);
                    }
                }
            }
            prioSum += priorities.stream().reduce((a, b) -> a + b).get();
        }
        System.out.println(prioSum);
        br.close();
    }
}
