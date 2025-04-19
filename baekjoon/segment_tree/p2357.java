package baekjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2357 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        long[] arr = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long[] minTree = new long[n * 4];
        long[] maxTree = new long[n * 4];
        initMinTree(minTree, arr, 1, 1, n);
        initMaxTree(maxTree, arr, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            long min = queryMin(minTree, 1, 1, n, a, b);
            long max = queryMax(maxTree, 1, 1, n, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    private static void initMinTree(long[] tree, long[] a, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            initMinTree(tree, a, node * 2, start, (start + end) / 2);
            initMinTree(tree, a, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    private static void initMaxTree(long[] tree, long[] a, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            initMaxTree(tree, a, node * 2, start, (start + end) / 2);
            initMaxTree(tree, a, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    private static long queryMin(long[] tree, int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Long.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        long lValue = queryMin(tree, node * 2, start, (start + end) / 2, left, right);
        long rValue = queryMin(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.min(lValue, rValue);
    }

    private static long queryMax(long[] tree, int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        long lValue = queryMax(tree, node * 2, start, (start + end) / 2, left, right);
        long rValue = queryMax(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.max(lValue, rValue);
    }
}
