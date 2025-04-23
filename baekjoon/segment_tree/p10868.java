package baekjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10868 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long[] tree = new long[n * 4];
        init(arr, tree, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            long min = query(tree, 1, 1, n, a, b);
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    private static void init(long[] arr, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            init(arr, tree, node * 2, start, (start + end) / 2);
            init(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }


    private static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        long leftMin = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rightMin = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.min(leftMin, rightMin);
    }
}
