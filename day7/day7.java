package AoC22.day7;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class day7 {
    public static void main(String[] args) throws IOException {
        String input = Files.readString(Paths.get("i:/code/AOC22/day7/input"));
        String[] lines = input.split("\r\n");

        Node curr = new Directory(new ArrayList<>(), "/", null);
        Node root = curr;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] words = line.split(" ");
            if (words[0].equals("$")) {
                switch (words[1]) {
                    case "cd":
                        if (words[2].equals("..")) {
                            curr = curr.parent;
                            break;
                        }
                        if (words[2].equals("/")) {
                            curr = root;
                            break;
                        }
                        for (Node c : curr.children) {
                            if (c.name.equals(words[2])) {
                                curr = c;
                                break;
                            }
                        }
                    case "ls":
                        for (int j = i + 1; j < lines.length; j++) {
                            if (lines[j].startsWith("$")) {
                                break;
                            }
                            if (lines[j].startsWith("dir")) {
                                curr.addChild(new Directory(new ArrayList<>(), lines[j].split(" ")[1], curr));
                            } else {
                                curr.addChild(new NodeFile(Integer.parseInt(lines[j].split(" ")[0]),
                                        new ArrayList<>(), lines[j].split(" ")[1], curr));
                            }
                        }
                }
            }
        }

        ArrayList<Node> dirs = new ArrayList<>();
        rec(root, dirs);
        int total = 0;
        int freeSpace = 70000000 - root.getTotalCh();
        int toFreeSpace = 30000000 - freeSpace;
        System.out.println(toFreeSpace);
        Collections.sort(dirs);
        for (Node n : dirs) {
            if (n.getTotalCh() >= toFreeSpace) {
                System.out.println(n.getTotalCh());
                break;
            }
        }
    }

    public static int getTotal(Node n) {
        int total = 0;
        if (n.getTotalCh() <= 100000 && n instanceof Directory) {
            total += n.getTotalCh();
        }
        for (Node child : n.children) {
            if (child.getTotalCh() <= 100000 && child instanceof Directory) {
                total += getTotal(child);
            }
        }
        return total;
    }

    public static void rec(Node n, ArrayList<Node> list) {
        if (n instanceof Directory) {
            list.add(n);
        }
        for (Node c : n.children) {
            rec(c, list);
        }
    }
}

abstract class Node implements Comparable<Node>{
    String name;
    ArrayList<Node> children;
    Node parent;

    public Node(ArrayList<Node> children, String name, Node parent) {
        this.children = children;
        this.name = name;
        this.parent = parent;
    }

    public void addChild(Node c) {
        this.children.add(c);
    }

    public int getTotalCh() {
        if (this instanceof NodeFile) {
            return ((NodeFile) this).size;
        } else {
            int total = 0;
            for (Node c : this.children) {
                total += c.getTotalCh();
            }
            return total;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.getTotalCh());
    }

    @Override
    public int compareTo(Node o) {
        return this.getTotalCh() - o.getTotalCh();
    }
}

class Directory extends Node {
    public Directory(ArrayList<Node> children, String name, Node parent) {
        super(children, name, parent);
    }
}

class NodeFile extends Node {
    int size;

    public NodeFile(int size, ArrayList<Node> children, String name, Node parent) {
        super(children, name, parent);
        this.size = size;
    }
}