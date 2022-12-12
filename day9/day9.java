package AoC22.day9;

import java.nio.file.Files;
import java.nio.file.Paths;

public class day9 {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("i:/code/AOC22/day9/input.test"));
        String[] lines = input.split("\n");
        int[] head = {0, 0};
        int[] tail = {0, 0};

        for (String l : lines) {
            String[] m = l.split(" ");
            switch (m[0]) {
                case "R":
                    head[0] += Integer.parseInt(m[1]);
                    break;
                case "L":
                    head[0] -= Integer.parseInt(m[1])
                    break;
                case "U":
                    head[1] += Integer.parseInt(m[1])
                    break;
                case "D":
                    head[1] -= Integer.parseInt(m[1])
                    break;
            }
            
        }
    }
}
