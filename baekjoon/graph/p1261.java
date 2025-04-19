package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p1261 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static int m;
    private static int n;
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        m = Integer.parseInt(inputs[0]);
        n = Integer.parseInt(inputs[1]);

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int[][] visited = new int[n][m];
        for (int[] ints : visited) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (arr[ny][nx] == '1') {
                    if (visited[ny][nx] > visited[current[1]][current[0]] + 1) {
                        visited[ny][nx] = visited[current[1]][current[0]] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                } else {
                    if (visited[ny][nx] > visited[current[1]][current[0]]) {
                        visited[ny][nx] = visited[current[1]][current[0]];
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return visited[n - 1][m - 1];
    }
}
