package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p14938 {

    private static int n;
    private static int m;
    private static List<Vertex>[] path;
    private static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        int r = Integer.parseInt(inputs[2]);

        items = new int[n + 1];
        inputs = br.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(inputs[i - 1]);
        }

        path = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            path[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int l = Integer.parseInt(inputs[2]);
            path[a].add(new Vertex(b, l));
            path[b].add(new Vertex(a, l));
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            answer = Math.max(dijkstra(i), answer);
        }

        System.out.println(answer);
    }

    private static int dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.add(new Vertex(start, 0));

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();

            int nowDistance = dist[current.v];
            if (nowDistance < current.distance) {
                continue;
            }

            for (Vertex next : path[current.v]) {
                if (dist[next.v] > nowDistance + next.distance) {
                    dist[next.v] = nowDistance + next.distance;
                    pq.add(next);
                }
            }
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] <= m) {
                count += items[i];
            }
        }

        return count;
    }

    static class Vertex {
        int v;
        int distance;

        public Vertex(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }
}
