package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9095 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp(n)).append("\n");
        }

        System.out.print(sb);
    }

    private static int dp(int n) {
        if (n <= 3) {
            return dp[n];
        }
        return dp[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
    }
}
