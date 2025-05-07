package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p2206 {

    private final static int[] dx = {0, 0, -1, 1};
    private final static int[] dy = {-1, 1, 0, 0};
    private static int n;
    private static int m;
    private static char[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = bfs(0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[n][m][2];

        queue.add(new Point(x, y, true, 1));
        visited[y][x][0] = true;

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == m - 1 && current.y == n - 1) {
                answer = Math.min(current.dist, answer);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (map[ny][nx] == '0') {
                    if (current.canBreak) {
                        if (visited[ny][nx][0]) {
                            continue;
                        }
                        queue.add(new Point(nx, ny, current.canBreak, current.dist + 1));
                        visited[ny][nx][0] = true;
                    } else {
                        if (visited[ny][nx][1]) {
                            continue;
                        }
                        queue.add(new Point(nx, ny, current.canBreak, current.dist + 1));
                        visited[ny][nx][1] = true;
                    }
                } else {
                    if (current.canBreak) {
                        queue.add(new Point(nx, ny, false, current.dist + 1));
                        visited[ny][nx][1] = true;
                    }
                }
            }
        }

        return answer;
    }

    static class Point {
        int x;
        int y;
        boolean canBreak;
        int dist;

        public Point(int x, int y, boolean canBreak, int dist) {
            this.x = x;
            this.y = y;
            this.canBreak = canBreak;
            this.dist = dist;
        }
    }
}
