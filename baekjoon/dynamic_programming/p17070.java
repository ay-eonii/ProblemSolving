package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                house[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        /*
        0 -> 가로
        1 -> 세로
        2 -> 대각선
         */
        int[][][] dp = new int[n][n][3];
        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (house[i][j] == 1) {
                    continue;
                }

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if (i == 0) {
                    continue;
                }
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (house[i - 1][j] == 1 || house[i][j - 1] == 1) {
                    continue;
                }
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }

        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}
