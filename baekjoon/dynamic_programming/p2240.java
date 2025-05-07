package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int t = Integer.parseInt(inputs[0]);
        int w = Integer.parseInt(inputs[1]);
        int[] tree = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[w + 1][t + 1];
        for (int i = 1; i < t + 1; i++) {
            if (tree[i] == 1) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < w + 1; i++) {
            for (int j = 1; j < t + 1; j++) {
                if (i % 2 == 0) { // 1번나무
                    if (tree[j] == 1) {
                        dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i - 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                } else {
                    if (tree[j] == 2) {
                        dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i - 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }

        System.out.println(dp[w][t]);

    }
}
