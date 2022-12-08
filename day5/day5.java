package AoC22.day5;

import java.io.*;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.regex.*;

/*
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 
 */
public class day5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("i:/code/AoC22/day5/input.test"));
        Stack stack1 = new Stack<>();
        Stack stack2 = new Stack<>();
        Stack stack3 = new Stack<>();
        stack1.push("Z");
        stack1.push("N");
        stack2.push("M");
        stack2.push("C");
        stack2.push("D");
        stack3.push("P");
        List<Stack<String>> stacks = new ArrayList<>();
        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);

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
                System.out.println("stack " + toStack + stacks.get(toStack-1));
            }
        }
        for (Stack<String> stack : stacks) {
            if (!stack.empty()) {
                System.out.println(stack.peek());
            }
        }

        br.close();
    }

}
