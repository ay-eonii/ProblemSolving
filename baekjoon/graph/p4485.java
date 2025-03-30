package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class p4485 {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t > 0; t++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] caves = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    caves[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dijkstra(caves, dist);
            sb.append(String.format("Problem %d: %d\n", t, dist[n - 1][n - 1]));
        }

        System.out.println(sb);
    }

    public static void dijkstra(int[][] caves, int[][] dist) {
        Queue<Node> pq = new PriorityQueue<>();
        dist[0][0] = caves[0][0];

        pq.add(new Node(0, 0, caves[0][0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.y][current.x] < current.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                int cost = current.cost + caves[ny][nx];
                if (cost < dist[ny][nx]) {
                    dist[ny][nx] = cost;
                    pq.add(new Node(nx, ny, cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
