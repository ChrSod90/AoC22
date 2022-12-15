package AoC22.day11;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class day11 {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("i:/code/AOC22/day11/input.test"));
        String[] monkeys = input.split("\r?\n\r?\n");
        for (String string : monkeys) {
            System.out.println("MONK : " + string);
        }
    }
}
