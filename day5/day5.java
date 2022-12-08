package AoC22.day5;

import java.io.*;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.regex.*;

/*
    [S] [C]         [Z]            
[F] [J] [P]         [T]     [N]    
[G] [H] [G] [Q]     [G]     [D]    
[V] [V] [D] [G] [F] [D]     [V]    
[R] [B] [F] [N] [N] [Q] [L] [S]    
[J] [M] [M] [P] [H] [V] [B] [B] [D]
[L] [P] [H] [D] [L] [F] [D] [J] [L]
[D] [T] [V] [M] [J] [N] [F] [M] [G]
 1   2   3   4   5   6   7   8   9 

 */
public class day5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day5/input"));
        /*
        String[] boxes = new String[3];
        boxes[0] = "ZN";
        boxes[1] = "MCD";
        boxes[2] = "p";
        */
        String[] boxes = new String[9];
        boxes[0] = "DLJRVGF";
        boxes[1] = "TPMBVHJS";
        boxes[2] = "VHMFDGPC";
        boxes[3] = "MDPNGQ";
        boxes[4] = "JLHNF";
        boxes[5] = "NFVQDGTZ";
        boxes[6] = "FDBL";
        boxes[7] = "MJBSVDN";
        boxes[8] = "GLD";


        List<Stack<String>> stacks = new ArrayList<>();
        for (String b : boxes) {
            Stack stack = new Stack<>();
            String[] foo = b.split("");
            for (String b2 : foo) {
                stack.push(b2);
            }
            //System.out.println(stack);
            stacks.add(stack);
        }
        
        String line;

        while ((line = br.readLine()) != null) {
            String[] foo = line.split("(\\s+)");
            /*
            int i = 0;
            for (String string : foo) {
                System.out.println(i + " : " + string);
                i++;
            }*/
            
            int amount = Integer.parseInt(foo[1]);
            int fromStack = Integer.parseInt(foo[3]);
            int toStack = Integer.parseInt(foo[5]);

            for (int n = 0; n < amount; n++) {
                stacks.get(toStack-1).push(stacks.get(fromStack-1).pop());
                //System.out.println("stack " + toStack + stacks.get(toStack-1));
            }
        }
        for (Stack<String> stack : stacks) {
            if (!stack.empty()) {
                System.out.print(stack.peek());
            }
        }

        br.close();
    }

}
