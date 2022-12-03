package AoC22.day2;

import java.io.*;
import java.util.*;

public class day2 {
    static final int rock = 1;
    static final int paper = 2;
    static final int scissors = 3;
    static final int win = 6;
    static final int draw = 3;
    static final int lose = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day2/input"));
        int score = 0;
        int scoreP2 = 0;

        Map<String, Integer> rpsMap = new HashMap<>();
        rpsMap.put("A", rock);
        rpsMap.put("X", rock);
        rpsMap.put("B", paper);
        rpsMap.put("Y", paper);
        rpsMap.put("C", scissors);
        rpsMap.put("Z", scissors);

        String line;
        while ((line = br.readLine()) != null) {
            String[] rps = line.trim().split(" ");
            if (rps.length != 2)
                continue;

            if (rpsMap.get(rps[0]) == rpsMap.get(rps[1])) {
                score += draw;
            } else if ((rpsMap.get(rps[0]) == rock) && (rpsMap.get(rps[1]) == paper)) {
                score += win;
            } else if ((rpsMap.get(rps[0]) == paper) && (rpsMap.get(rps[1]) == scissors)) {
                score += win;
            } else if ((rpsMap.get(rps[0]) == scissors) && (rpsMap.get(rps[1]) == rock)) {
                score += win;
            } else {
                score += lose;
            }
            score += rpsMap.get(rps[1]);
            // part 2
            if (rps[1].equals("Y")) {
                if (rpsMap.get(rps[0]) == rock) {
                    scoreP2 += rock;
                } else if (rpsMap.get(rps[0]) == paper) {
                    scoreP2 += paper;
                } else if (rpsMap.get(rps[0]) == scissors) {
                    scoreP2 += scissors;
                }
                scoreP2 += draw;
            } else if (rps[1].equals("Z")) {
                if (rpsMap.get(rps[0]) == rock) {
                    scoreP2 += paper;
                } else if (rpsMap.get(rps[0]) == paper) {
                    scoreP2 += scissors;
                } else if (rpsMap.get(rps[0]) == scissors) {
                    scoreP2 += rock;
                }
                scoreP2 += win;
            } else if (rps[1].equals("X")) {
                if (rpsMap.get(rps[0]) == rock) {
                    scoreP2 += scissors;
                } else if (rpsMap.get(rps[0]) == paper) {
                    scoreP2 += rock;
                } else if (rpsMap.get(rps[0]) == scissors) {
                    scoreP2 += paper;
                }
                scoreP2 += lose;
            }
        }
        System.out.println("part1: " + score);
        System.out.println("part2: " + scoreP2);
        br.close();
    }
}
