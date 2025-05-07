package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // dp[w][h]: 남은 통 알약 w개, 반 알약 h개일 때 경우의 수
        long[][] dp = new long[31][31];
        for (int i = 1; i < 31; i++) {
            dp[0][i] = 1;
        }

        for (int w = 1; w <= 30; w++) {
            for (int h = 0; h <= 30 - w; h++) {
                if (h > 0) {
                    dp[w][h] = dp[w - 1][h + 1] + dp[w][h - 1];
                } else {
                    dp[w][h] = dp[w - 1][h + 1];
                }
            }
        }

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            System.out.println(dp[n][0]);
        }
    }
}
