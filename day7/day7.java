package AoC22.day7;

import java.io.*;
import java.util.*;

public class day7 {
    public static void main(String[] args) throws IOException {
        FClass root = new FClass(0, "/", false, null);
        FClass curr = root;

        List<FClass> ft = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day7/input.test"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] commands = line.split(" ");
            if (commands[0].equals("$")) {
                if (commands[1].equals("cd")) {
                    if (commands[2].equals("/")) {
                        curr = root;
                    } else if (commands[2].equals("..")) {
                        curr = curr.parent;
                    } else {
                        FClass fc = new FClass(0, line, false, curr);
                        ft.add(fc);
                        curr = fc;
                    }
                }
            } else if (!commands[0].equals("dir")) {
                curr.size = Integer.parseInt(commands[0]);
                if (curr.parent != null) {
                    curr.parent.size += curr.size;
                    System.out.println(curr.parent.size);
                }            
            }
        }
        br.close();
    }

    private static class FClass {
        String name;
        int size = 0;
        boolean file = true;
        List<FClass> subElements = new ArrayList<>();
        FClass parent = null;

        FClass(int size, String name, boolean file, FClass parent) {
            this.size = size;
            this.name = name;
            this.file = file;
            this.parent = parent;
        }
    }
}