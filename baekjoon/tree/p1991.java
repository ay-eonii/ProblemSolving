package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1991 {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] tree = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            int parentIndex = inputs[0] - 'A';
            int leftIndex = inputs[2] - 'A';
            int rightIndex = inputs[4] - 'A';
            if (tree[parentIndex] == null) {
                tree[parentIndex] = new Node(inputs[0]);
            }
            if (inputs[2] != '.') {
                tree[leftIndex] = new Node(inputs[2]);
                tree[parentIndex].left = tree[leftIndex];
            }
            if (inputs[4] != '.') {
                tree[rightIndex] = new Node(inputs[4]);
                tree[parentIndex].right = tree[rightIndex];
            }
        }

        sb = new StringBuilder();
        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);

        System.out.print(sb);
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        sb.append(node.data);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.data);
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
