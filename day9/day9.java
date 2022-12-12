package AoC22.day9;

import java.nio.file.Files;
import java.nio.file.Paths;

public class day9 {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("i:/code/AOC22/day9/input.test"));
        String[] lines = input.split("\r\n");
        int[] head = { 0, 0 };
        int[] tail = { 0, 0 };

        for (String l : lines) {
            System.out.println(l);
            String[] m = l.split(" ");
            System.out.println(m[1]);
            int nSteps = Integer.parseInt(m[1]);
            for (int i = 0; i < nSteps; i++) {
                step(m[0], head);
                System.out.println("head: " + head[0] +" " + head[1]);
            }
        }
    }
    private static void step(String m, int[] rope){
        switch (m) {
            case "R":
                rope[0] += 1;
                break;
            case "L":
                rope[0] -= 1;
                break;
            case "U":
                rope[1] += 1;
                break;
            case "D":
                rope[1] -= 1;
                break;
        }
    }
}
