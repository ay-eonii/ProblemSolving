package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000;
            }
        }

        System.out.println(dp[k][n]);
    }
}
