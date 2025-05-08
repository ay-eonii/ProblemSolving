package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p13301 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 2];
        dp[1] = 1;
        for (int i = 2; i < n + 2; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println((dp[n] * 2) + (dp[n + 1] * 2));
    }
}
