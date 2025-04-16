package baekjoon.graph;

/*
1. 아이디어
2. 시간복잡도
3. 자료구조
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p16234 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static int[][] a;
    private static int l;
    private static int r;
    private static int n;
    private static Queue<Point> queue;
    private static boolean[][] visited;
    private static List<Point> federation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        l = Integer.parseInt(inputs[1]);
        r = Integer.parseInt(inputs[2]);

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int answer = 0;
        queue = new LinkedList<>();
        while (true) {
            boolean isMove = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        continue;
                    }

                    federation = new ArrayList<>();
                    int sum = bfs(j, i);
                    if (federation.size() > 1) {
                        move(sum);
                        isMove = true;
                    }
                }
            }
            if (!isMove) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

    private static int bfs(int x, int y) {
        queue.add(new Point(x, y));
        visited[y][x] = true;

        int sum = a[y][x];
        federation.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx]) {
                    continue;
                }

                int diff = Math.abs(a[ny][nx] - a[current.y][current.x]);
                if (diff < l || diff > r) {
                    continue;
                }

                queue.add(new Point(nx, ny));
                sum += a[ny][nx];
                federation.add(new Point(nx, ny));
                visited[ny][nx] = true;
            }
        }
        return sum;
    }

    private static void move(int sum) {
        int size = federation.size();
        if (size <= 1) {
            return;
        }

        int avg = sum / size;
        for (Point point : federation) {
            a[point.y][point.x] = avg;
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
