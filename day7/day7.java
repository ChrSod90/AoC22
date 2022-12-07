package AoC22.day7;

import java.io.*;
import java.util.*;

public class day7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day7/input.test"));

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