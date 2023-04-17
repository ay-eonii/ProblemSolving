package baekjoon.dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9461 {
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new long[101];
        dp[1] = dp[2] = 1;
        dp[3] = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            padovan(N);
            System.out.println(dp[N]);
        }
    }

    private static void padovan(int N) {
        for (int j = 4; j <= N; j++) {
            dp[j] = dp[j - 2] + dp[j - 3];
        }
    }
}
