package baekjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);

        long[] a = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = Long.parseLong(br.readLine());
        }

        long[] tree = new long[n * 4];
        init(a, tree, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            inputs = br.readLine().split(" ");
            int b = Integer.parseInt(inputs[1]);
            long c = Long.parseLong(inputs[2]);
            if ("1".equals(inputs[0])) {
                long diff = c - a[b];
                a[b] = c;
                modify(tree, 1, 1, n, b, diff);
            } else {
                long sum = query(tree, 1, 1, n, b, c);
                sb.append(sum).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void init(long[] a, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    private static void modify(long[] tree, int node, int start, int end, int index, long diff) {
        if (index < start || index > end) {
            return;
        }
        tree[node] = tree[node] + diff;
        if (start != end) {
            modify(tree, node * 2, start, (start + end) / 2, index, diff);
            modify(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }

    private static long query(long[] tree, int node, int start, int end, int left, long right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        long sumL = query(tree, node * 2, start, (start + end) / 2, left, right);
        long sumR = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return sumL + sumR;
    }
}
