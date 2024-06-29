package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11727 {

    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        System.out.print(recur(n));
    }

    private static int recur(int n) {
        if (dp[n] != null) {
            return dp[n] % 10007;
        }

        if (n % 2 == 0) {
            return dp[n] = (recur(n / 2) * recur(n / 2) + 2 * recur((n - 2) / 2) * recur((n - 2) / 2)) % 10007;
        } else {
            return dp[n] = (recur(n / 2) * recur(n / 2 + 1) + 2 * recur((n - 2) / 2) * recur((n - 2) / 2 + 1)) % 10007;
        }
    }
}

// strategy
// dp
