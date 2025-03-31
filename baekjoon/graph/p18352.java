package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p18352 {

    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        int x = Integer.parseInt(inputs[3]);

        List<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            edges[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
        }

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs(edges, x);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb.isEmpty() ? -1 : sb);
    }

    private static void bfs(List<Integer>[] edges, int x) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        dist[x] = 0;
        queue.add(x);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            visited[current] = true;

            for (Integer edge : edges[current]) {
                if (!visited[edge]) {
                    dist[edge] = Math.min(dist[current] + 1, dist[edge]);
                    queue.add(edge);
                }
            }
        }
    }
}
