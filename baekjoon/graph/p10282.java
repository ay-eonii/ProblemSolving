package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class p10282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int d = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            List<Node>[] edges = new ArrayList[n + 1];
            int[] dist = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                edges[j] = new ArrayList<>();
                dist[j] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < d; j++) {
                inputs = br.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                int s = Integer.parseInt(inputs[2]);
                edges[b].add(new Node(a, s));
            }

            dijkstra(c, edges, dist);

            int max = 0;
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    count++;
                    max = Math.max(dist[j], max);
                }
            }

            sb.append(count).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start, List<Node>[] edges, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[edges.length];
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int current = pq.poll().index;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            for (Node next : edges[current]) {
                if (dist[next.index] > dist[current] + next.cost) {
                    dist[next.index] = dist[current] + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
