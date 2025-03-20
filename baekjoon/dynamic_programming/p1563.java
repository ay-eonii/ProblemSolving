package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1563 {

    private static Integer[][][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1][3][4];

        int answer = solve(0, 0, 0);
        System.out.println(answer);
    }

    private static int solve(int len, int late, int absent) {
        if (dp[len][late][absent] != null) {
            return dp[len][late][absent];
        }

        if (late > 1 || absent == 3) {
            return 0;
        }

        if (len >= n) {
            return 1;
        }

        dp[len][late][absent] = solve(len + 1, late, 0) // 출석
                + solve(len + 1, late, absent + 1) // 결석
                + solve(len + 1, late + 1, 0); // 지각

        return dp[len][late][absent] % 1_000_000;
    }
}
