package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2156 {
    private static Integer[] dp;
    private static Integer[] wine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        wine = new Integer[N + 1];
        for (int i = 1; i < dp.length; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = wine[1];

        if (N > 1) {
            dp[2] = wine[1] + wine[2];
        }

        System.out.println(recur(N));
    }

    public static int recur(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + wine[N - 1]) + wine[N], recur(N - 1));
        }
        return dp[N];
    }
}

/*
 * 1. 1잔, 2잔 연속 먹기 가능
 * 2. (r - 1) + (r - 2), (r - 1) + (r - 3), (r - 2) + (r - 3)
 * 2. 마지막 잔으로 끝내거나, 마지막 전 잔으로 끝내거나
 * 3. max(dp[N - 1], dp[N - 2])
 * */
