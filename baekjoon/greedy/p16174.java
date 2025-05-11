package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p16174 {

    private static final int[] dx = {1, 0};
    private static final int[] dy = {0, 1};
    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j + 1] = Integer.parseInt(inputs[j]);
            }
        }

        if (bfs()) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        boolean[][] visited = new boolean[n + 1][n + 1];
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nx = current.x + (map[current.y][current.x] * dx[i]);
                int ny = current.y + (map[current.y][current.x] * dy[i]);

                if (nx > n || ny > n || visited[ny][nx]) {
                    continue;
                }

                if (nx + ny + map[ny][nx] > n * 2) {
                    continue;
                }

                if (map[ny][nx] == -1) {
                    return true;
                }

                queue.add(new Point(nx, ny));
                visited[ny][nx] = true;
            }
        }

        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
