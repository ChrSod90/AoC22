package AoC22.day4;

import java.io.*;

public class day4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day4/input"));

        String line;
        int count = 0;
        int countp2 = 0;
        int totalSections=0;
        while ((line = br.readLine()) != null) {
            String[] groupSections = line.split(",");
            String[] sectionA = groupSections[0].split("-");
            String[] sectionB = groupSections[1].split("-");

            int startA = Integer.parseInt(sectionA[0]);
            int endA = Integer.parseInt(sectionA[1]);
            int startB = Integer.parseInt(sectionB[0]);
            int endB = Integer.parseInt(sectionB[1]);

            if (startA <= startB && endA >= endB) {
                count++;                
            }else if (startA >= startB && endA <= endB) {
                count++;
            }
            //part2
            if (startA > endB) {
                countp2++;
            }else if (startB > endA) {
                countp2++;
            }
            totalSections++;
        }
        System.out.println(count);
        System.out.println(totalSections-countp2);
        br.close();
    }
}
