package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1504 {

    private static int n;
    private static long[][] arr;
    private static List<Node>[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        int e = Integer.parseInt(inputs[1]);

        arr2 = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr2[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            arr2[a].add(new Node(b, c));
            arr2[b].add(new Node(a, c));
        }

        inputs = br.readLine().split(" ");
        int v = Integer.parseInt(inputs[0]);
        int u = Integer.parseInt(inputs[1]);


        long[] dist1 = dijkstra(1);
        long[] distV = dijkstra(v);
        long[] distU = dijkstra(u);

        // 1 -> v -> u -> n
        long vu = dist1[v] + distV[u] + distU[n];
        long uv = dist1[u] + distU[v] + distV[n];

        long min = Math.min(vu, uv);
        if (min >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void floyd(int v, int u) {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) {
                        continue;
                    }
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        long answer = Math.min(arr[1][v] + arr[v][u] + arr[u][n], arr[1][u] + arr[u][v] + arr[v][n]);
        if (answer >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static long[] dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.v] < current.c) {
                continue;
            }

            for (Node next : arr2[current.v]) {
                if (dist[next.v] > dist[current.v] + next.c) {
                    dist[next.v] = dist[current.v] + next.c;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node> {
        int v;
        long c;

        public Node(int v, long c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.c, o.c);
        }
    }
}
