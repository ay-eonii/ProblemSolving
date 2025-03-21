package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i + 1] = dp[i + 1] = Integer.parseInt(inputs[i]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
