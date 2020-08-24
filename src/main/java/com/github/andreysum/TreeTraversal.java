package com.github.andreysum;

public class TreeTraversal {
    public static void main(String[] args) {
        new TreeTraversal().run();
    }
    void run() {
        Node root = new Node();
        root.left = new Node("l");
        root.right = new Node("r");
        root.left.left = new Node("ll");
        root.left.right = new Node("lr");
        root.right.left = new Node("rl");
        root.right.right = new Node("rr");
        root.right.right.right = new Node("rrr");
        root.right.right.left = new Node("rrl");
        int dept = 0;
        inFix(root, dept);
    }

    private int inFix(Node node, int dept) {
        if (node != null) {
            dept = inFix(node.left, ++dept);
            dept = inFix(node.right, ++dept);
            System.out.printf(node.data == null ? "null" : node.data);
            System.out.println(" " + dept);
            return --dept;
        } else {
            return --dept;
        }
    }

    class Node {
        Node right;
        Node left;
        String data;
        Node() {
            this(null);
        }
        Node (String d) {
            data = d;
        }
    }
}
