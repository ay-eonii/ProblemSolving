package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1932 {

    private static int[][] triangle;
    private static Integer[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new Integer[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        System.out.println(find(0, 0));
    }

    private static int find(int depth, int idx) {
        if (depth == n - 1) {
            return dp[depth][idx];
        }
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + triangle[depth][idx];
        }
        return dp[depth][idx];
    }
}
