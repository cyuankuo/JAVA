package edu.nyu.cs9053.homework8;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Node<T> {

    private final HashMap<Character, Node> children;

    private String outputString;

    public Node() {
        children = new HashMap<>();
    }

    public Node get(Character c) {
        return this.children.get(Character.toLowerCase(c));
    }

    public List<String> getAllValues() {
        List<String> values = new LinkedList<>();

        for (Node children : this.children.values()) {
            values.addAll(children.getAllValues());
        }

        if (this.outputString != null) {
            values.add(this.outputString);
        }
        return values;
    }

    public static void insert(Node node, String word) {
        for (char c : word.toCharArray()) {
            c = Character.toLowerCase(c);
            if(!node.children.containsKey(c)) {
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
        }
        if (node.outputString == null) {
            node.outputString = word;
        }
    }
}
