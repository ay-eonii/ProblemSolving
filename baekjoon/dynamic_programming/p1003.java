package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1003 {
    private static final Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp[0] = new Integer[]{1, 0};
        dp[1] = new Integer[]{0, 1};
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int zero = fibonacci(n, 0);
            int one = fibonacci(n, 1);
            sb.append(zero + " " + one).append("\n");
        }
        System.out.print(sb);
    }

    static int fibonacci(int n, int index) {
        if (dp[n][index] != null) {
            return dp[n][index];
        }

        return dp[n][index] = fibonacci(n - 1, index) + fibonacci(n - 2, index);
    }
}

//k -> dp[k-1] + dp[k-2]

