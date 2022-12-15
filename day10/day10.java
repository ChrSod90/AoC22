package AoC22.day10;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class day10 {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("i:/code/AOC22/day10/input"));
        String[] lines = input.split("\r\n");
        int cycleCount = 1;
        int xReg = 1;
        int sigStrength = 0;
        int sigSum = 0;
        for (String string : lines) {
            String[] s = string.split(" ");
            if (s[0].equals("noop")) {
                cycleCount += 1;
                sigStrength = xReg * cycleCount;
                if (cycleCount == 20 || cycleCount == 60 || cycleCount == 100 || cycleCount == 140 || cycleCount == 180
                        || cycleCount == 220) {
                    sigSum += sigStrength;
                }
                draw(cycleCount, xReg);
            }
            if (s[0].equals("addx")) {
                cycleCount += 1;
                sigStrength = xReg * cycleCount;
                if (cycleCount == 20 || cycleCount == 60 || cycleCount == 100 || cycleCount == 140 || cycleCount == 180
                        || cycleCount == 220) {
                    sigSum += sigStrength;
                }
                draw(cycleCount, xReg);
                //System.out.println(cycleCount + " : " + xReg + " : " + sigStrength);

                cycleCount += 1;
                xReg += Integer.parseInt(s[1]);
                sigStrength = xReg * cycleCount;
                if (cycleCount == 20 || cycleCount == 60 || cycleCount == 100 || cycleCount == 140 || cycleCount == 180
                        || cycleCount == 220) {
                    sigSum += sigStrength;
                }
                draw(cycleCount, xReg);

            }
        }
    }
    private static void draw(int cycleCount, int x) {
        int currPixel = (cycleCount % 40);

        if (currPixel < x || currPixel > x + 2) {
            System.out.print(".");
        } else {
            System.out.print("#");
        }
        if (currPixel == 0) {
            System.out.println();
        }
    }
}
