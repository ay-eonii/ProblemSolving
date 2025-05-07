package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p4963 {

    private static final int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static final int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int w;
    private static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs;
        StringBuilder sb = new StringBuilder();
        while (!(inputs = (br.readLine())).equals("0 0")) {
            String[] split = inputs.split(" ");
            w = Integer.parseInt(split[0]);
            h = Integer.parseInt(split[1]);

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                split = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(split[j]);
                }
            }

            boolean[][] visited = new boolean[h][w];
            int answer = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (map[y][x] == 0 || visited[y][x]) {
                        continue;
                    }
                    bfs(map, x, y, visited);
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int[][] map, int x, int y, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h || visited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    continue;
                }

                queue.add(new Point(nx, ny));
                visited[ny][nx] = true;
            }
        }
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
