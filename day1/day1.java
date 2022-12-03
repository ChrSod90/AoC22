package AoC22.day1;

import java.io.*;
import java.util.*;

public class day1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day1/input"));

        int cal = 0;
        int maxCal = 0;
        String line;
        List<Integer> list = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String sLine = line.trim();
            if (sLine.isBlank()) {
                if (maxCal < cal) {
                    maxCal = cal;
                }
                list.add(cal);
                cal = 0;
                continue;
            }
            cal += Integer.parseInt(sLine);
        }
        list.add(cal);
        if (maxCal < cal) {
            maxCal = cal;
        }
        System.out.println(maxCal);

        br.close();

    }
}
