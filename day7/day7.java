package AoC22.day7;

import java.io.*;
import java.util.*;

public class day7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day7/input.test"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] commands = line.split(" ");
            if (commands[0].equals("$")) {
                if (commands[1].equals("cd")) {
                    if (commands[2].equals("/")) {
                        //Do root shit
                    }else if (commands[2].equals("..")) {
                        //Get parent
                    }else{
                        //enter sub dir
                    }
                }
            }else if (commands[0].equals("dir")) {
                //create sub dirr to curr dir
                
            }else{
                //add files to curr dirr?
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