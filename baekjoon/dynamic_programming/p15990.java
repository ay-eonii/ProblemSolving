package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15990 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long[][] dp = new long[4][100_001];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 100_001; i++) {
            dp[1][i] = (dp[2][i - 1] + dp[3][i - 1]) % 1_000_000_009;
            dp[2][i] = (dp[1][i - 2] + dp[3][i - 2]) % 1_000_000_009;
            dp[3][i] = (dp[1][i - 3] + dp[2][i - 3]) % 1_000_000_009;
        }

        for (int t : arr) {
            long answer = (dp[1][t] + dp[2][t] + dp[3][t]) % 1_000_000_009;
            System.out.println(answer);
        }
    }
}
