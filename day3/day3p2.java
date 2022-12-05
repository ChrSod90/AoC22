package AoC22.day3;

import java.io.*;
import java.util.*;

public class day3p2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day3/input"));
        int prioSum = 0;

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int listCount = 0;
        String line;
        List<Set<Integer>> lists = new ArrayList<>();
        lists.add(new HashSet<>());
        lists.add(new HashSet<>());
        lists.add(new HashSet<>());

        while ((line = br.readLine()) != null) {

            for (String e : line.split("")) {
                lists.get(listCount).add(alphabet.indexOf(e) + 1);
            }

            listCount++;

            if (listCount < 3) {
                continue;
            }

            lists.get(0).retainAll(lists.get(1));
            lists.get(0).retainAll(lists.get(2));

            prioSum += lists.get(0).stream().reduce((a, b) -> a + b).get();

            lists = new ArrayList<>();
            lists.add(new HashSet<>());
            lists.add(new HashSet<>());
            lists.add(new HashSet<>());
            listCount = 0;
        }
        System.out.println(prioSum);
        br.close();
    }
}
