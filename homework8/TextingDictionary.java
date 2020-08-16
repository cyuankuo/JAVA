package edu.nyu.cs9053.homework8;

import java.util.LinkedList;
import java.util.List;

public class TextingDictionary {

    private Node root;

    public TextingDictionary() {
        root = new Node();
    }

    public void insert(String word) {
        Node.insert(this.root, word);
    }

    public List<String> search(List<ValidTextKeyPress> prefixes) {
        List<Node> hits = new LinkedList<>();
        hits.add(this.root);

        for (ValidTextKeyPress key : prefixes) {
            List<Node> next = new LinkedList<>();

            for (Node node : hits) {
                for (Character c : key.getCharacters()) {
                    if (node.get(c) != null) {
                        next.add(node.get(c));
                    }
                }
            }
            hits = next;
        }

        List<String> result = new LinkedList<>();
        for (Node hit : hits) {
            result.addAll(hit.getAllValues());
        }
        return result;
    }
}
