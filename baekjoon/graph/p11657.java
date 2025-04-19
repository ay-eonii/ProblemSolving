package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p11657 {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        List<Node> path = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            path.add(new Node(a, b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < n; i++) {
            for (Node node : path) {
                if (dist[node.from] != INF && dist[node.from] + node.cost < dist[node.to]) {
                    dist[node.to] = dist[node.from] + node.cost;
                }
            }
        }

        boolean hasNegativeCycle = false;
        for (Node node : path) {
            if (dist[node.from] != INF && dist[node.from] + node.cost < dist[node.to]) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            System.out.println(-1);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 2; i < n + 1; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    stringBuilder.append(-1);
                } else {
                    stringBuilder.append(dist[i]);
                }
                stringBuilder.append("\n");
            }
            System.out.print(stringBuilder);
        }
    }

    static class Node {
        int from;
        int to;
        long cost;

        public Node(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
