package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p15591 {

    private static int N;
    private static int Q;
    private static List<Node>[] videos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        Q = Integer.parseInt(inputs[1]);

        videos = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            videos[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            inputs = br.readLine().split(" ");
            int p = Integer.parseInt(inputs[0]);
            int q = Integer.parseInt(inputs[1]);
            int r = Integer.parseInt(inputs[2]);
            videos[p].add(new Node(q, r));
            videos[q].add(new Node(p, r));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            inputs = br.readLine().split(" ");
            int k = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            int answer = bfs(k, v);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int k, int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(v);
        visited[v] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Node next : videos[current]) {
                if (visited[next.v]) {
                    continue;
                }

                if (next.cost >= k) {
                    answer++;
                    queue.add(next.v);
                    visited[next.v] = true;
                }
            }
        }

        return answer;
    }

    static class Node {

        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
