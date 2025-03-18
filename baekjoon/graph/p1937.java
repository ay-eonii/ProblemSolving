package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1937 {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static int[][] dp;
    private static int n;
    private static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp = new int[n][n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(j, i), max);
            }
        }

        System.out.println(max);
    }

    private static int dfs(int x, int y) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        dp[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= n || ny >= n || nx < 0 || ny < 0) {
                continue;
            }
            if (area[ny][nx] <= area[y][x]) {
                continue;
            }
            dp[y][x] = Math.max(dfs(nx, ny) + 1, dp[y][x]);
        }
        return dp[y][x];
    }
}
