package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        if (k <= n) {
            System.out.println(n - k);
            return;
        }

        int[] dp = new int[k + 2];

        for (int i = 0; i < k + 2; i++) {
            dp[i] = Math.abs(n - i);
        }

        for (int i = 1; i <= k; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1], dp[i + 1]) + 1, dp[i]);
            if (i * 2 < k + 2 && dp[i * 2] != 0) {
                dp[i * 2] = dp[i];
            }
        }

        System.out.println(dp[k]);
    }
}
