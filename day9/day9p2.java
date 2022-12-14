package AoC22.day9;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class day9p2 {
    public static Set<ArrayList<Integer>> visited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("i:/code/AOC22/day9/input.test2"));
        String[] lines = input.split("\r\n");

        ArrayList<ArrayList<Integer>> rope = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            rope.add(new ArrayList<>());
        }
        for (ArrayList<Integer> r : rope) {
            r.add(0);
            r.add(0);
        }

        for (String l : lines) {
            // System.out.println(l);
            String[] m = l.split(" ");
            // System.out.println(m[1]);
            int nSteps = Integer.parseInt(m[1]);
            boolean last = false;
            for (int j = 0; j < 9; j++) {
                last = j==8;
                for (int i = 0; i < nSteps; i++) {
                    step(m[0], rope.get(j));
                    tailFollow(rope.get(j), rope.get(j+1), last);
                    // System.out.println("head: " + head.get(0) + " " + head.get(1));
                    // System.out.println("tail: " + tail.get(0) + " " + tail.get(1));
                }
            }
        }

        System.out.println(visited.size());
    }

    private static void tailFollow(ArrayList<Integer> head, ArrayList<Integer> tail, boolean last) {
        
        int diffX = Math.abs(tail.get(0) - head.get(0));
        int diffY = Math.abs(tail.get(1) - head.get(1));

        if (diffX == 2) {
            if (tail.get(0) < head.get(0)) {
                tail.set(0, tail.get(0) + 1);
            } else {
                tail.set(0, tail.get(0) - 1);
            }
            if (diffX != 0) {
                tail.set(1, head.get(1));
            }
        }
        if (diffY == 2) {
            if (tail.get(1) < head.get(1)) {
                tail.set(1, tail.get(1) + 1);
            } else {
                tail.set(1, tail.get(1) - 1);
            }
            if (diffY != 0) {
                tail.set(0, head.get(0));
            }
        }
        if (last) {
            ArrayList<Integer> temp = new ArrayList<>(tail);
            visited.add(temp);
        }
    }

    private static void step(String m, ArrayList<Integer> rope) {
        switch (m) {
            case "R":
                rope.set(0, rope.get(0) + 1);
                break;
            case "L":
                rope.set(0, rope.get(0) - 1);
                break;
            case "U":
                rope.set(1, rope.get(1) + 1);
                break;
            case "D":
                rope.set(1, rope.get(1) - 1);
                break;
        }
    }
}
