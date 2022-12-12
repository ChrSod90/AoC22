package AoC22.day8;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class day8 {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("i:/code/AOC22/day8/input"));
        String[] lines = input.split("\r\n");

        int[][] grid = new int[lines.length][lines[0].length()];
        boolean[][] visGrid = new boolean[lines.length][lines[0].length()];

        for (int j = 0; j < lines.length; j++) {
            String line = lines[j];
            int[] row = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                row[i] = Integer.parseInt(String.valueOf(line.charAt(i)));
            }
            grid[j] = row;
        }

        for (int i = 0; i < visGrid.length; i++) {
            int[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == line.length - 1) {
                    visGrid[i][j] = true;
                }
                boolean b1 = true;
                for (int k = 0; k < j; k++) {
                    if (grid[i][k] >= grid[i][j]) {
                        b1 = false;
                        break;
                    }
                }
                boolean b2 = true;
                for (int k = line.length - 1; k > j; k--) {
                    if (grid[i][k] >= grid[i][j]) {
                        b2 = false;
                        break;
                    }
                }
                boolean b3 = true;
                for (int k = 0; k < i; k++) {
                    if (grid[k][j] >= grid[i][j]) {
                        b3 = false;
                        break;
                    }
                }
                boolean b4 = true;
                for (int k = grid.length - 1; k > i; k--) {
                    if (grid[k][j] >= grid[i][j]) {
                        b4 = false;
                        break;
                    }
                }
                visGrid[i][j] = b1 || b2 || b3 || b4;
            }
        }
        int total = 0;
        for (boolean[] a : visGrid) {
            for (boolean b : a) {
                if (b) {
                    total++;
                }
            }
        }
        //System.out.println(total);
        // part2
        System.out.println(scenicScore(4, 4, grid));
        int biggest = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                biggest = Math.max(biggest, scenicScore(i, j, grid));
            }
        }
        System.out.println(biggest);
    }

    private static int scenicScore(int row, int col, int[][] grid) {
        int height = grid[row][col];
        int dir = 0;
        int total = 1;
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] < height) {
                dir++;
            } else {
                dir++;
                break;
            }
        }
        total *= dir;
        dir = 0;
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] < height) {
                dir++;
            } else {
                dir++;
                break;
            }
        }
        total *= dir;
        dir = 0;
        for (int i = col - 1; i >= 0; i--) {
            if (grid[row][i] < height) {
                dir++;
            } else {
                dir++;
                break;
            }
        }
        total *= dir;
        dir = 0;
        for (int i = col + 1; i < grid[row].length; i++) {
            if (grid[row][i] < height) {
                dir++;
            } else {
                dir++;
                break;
            }
        }
        total *= dir;
        return total;
    }
}
