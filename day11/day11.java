package AoC22.day11;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class day11 {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("i:/code/AOC22/day11/input.test"));
        String[] monkeysInput = input.split("\r?\n\r?\n");
        
        ArrayList<Monkey> monkeys = new ArrayList<>();
        ArrayList<Integer> divs = new ArrayList<>();

        for (String m : monkeysInput) {
            String[] lines = m.split("\r?\n");
            String items = lines[1].substring(18);
            Monkey monkey = new Monkey(items, lines[2].strip(), String.join("=", lines[3].strip(), lines[4].strip(), lines[5].strip()));
            monkeys.add(monkey);
            divs.add(Integer.parseInt(lines[3].strip().split(" ")[3]));
        }
        for (Monkey m : monkeys) {
            System.out.println(m.itemsHeld);
        }
    }
}

