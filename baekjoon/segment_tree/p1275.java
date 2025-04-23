package baekjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1275 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int q = Integer.parseInt(inputs[1]);

        long[] arr = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] tree = new long[n * 4];
        init(arr, tree, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            int a = Integer.parseInt(inputs[2]);
            int b = Integer.parseInt(inputs[3]);

            long sum = query(tree, 1, 1, n, Math.min(x, y), Math.max(x, y));
            update(tree, 1, 1, n, a, (long) b - arr[a]);
            arr[a] = b;
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    private static void update(long[] tree, int node, int start, int end, int a, long diff) {
        if (a < start || end < a) {
            return;
        }
        tree[node] += diff;
        if (start != end) {
            update(tree, node * 2, start, (start + end) / 2, a, diff);
            update(tree, node * 2 + 1, (start + end) / 2 + 1, end, a, diff);
        }
    }

    private static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long leftSum = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rightSum = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return leftSum + rightSum;
    }

    private static void init(long[] arr, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            init(arr, tree, node * 2, start, (start + end) / 2);
            init(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}
