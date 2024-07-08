package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p2667 {
    private static final int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static final int[] dy = {1, -1, 0, 0}; // 상하좌우
    private static boolean[][] visited;
    private static int[][] town;
    private static int n;
    private static int count = 0;
    private static List<Integer> answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        town = new int[n][n];
        visited = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            String[] inputs = br.readLine().split("");
            for (int x = 0; x < n; x++) {
                town[y][x] = Integer.parseInt(inputs[x]);
            }
        }

        answers = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x] && town[y][x] == 1) {
                    bfs(x, y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        Collections.sort(answers);
        for (Integer answer : answers) {
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[y][x] = true;
        count++;

        int house = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            house++;
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx]) {
                    continue;
                }
                if (town[ny][nx] == 1) {
                    queue.add(new Node(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }

        answers.add(house);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// strategy
// bfs
