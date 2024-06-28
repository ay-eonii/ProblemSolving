package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1916 {

    private static List<Node>[] list;
    private static boolean[] visited;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스 수

        list = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            distance[i] = 100_000_001;
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            list[from].add(new Node(to, cost));
        }

        String[] inputs = br.readLine().split(" ");
        int from = Integer.parseInt(inputs[0]);
        int to = Integer.parseInt(inputs[1]);

        distance[from] = 0; // from 1 to 1 = 0
        dijkstra(new Node(from, 0)); // 1

        System.out.print(distance[to]);
    }

    static void dijkstra(Node start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // 1 4
            if (visited[current.to]) {
                continue;
            }
            visited[current.to] = true;

            for (Node next : list[current.to]) { // 1에서 2 3 4
                if (distance[next.to] > distance[current.to] + next.value) { // next 거쳐서 가기 vs direct 가기
                    distance[next.to] = distance[current.to] + next.value;
                    queue.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}

// strategy
// 플로이드워샬
// min(a to c + c to b, a to b)

// 다 구할필요 없음
// 다익스트라
//
