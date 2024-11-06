package baekjoon.dynamic_programming;

/*
1. 아이디어
- k원 : k-1원 + 동전 1개
2. 시간복잡도
- O(N)
3. 자료구조
- dp = int[]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 0;
        for (int i = 1; i < k + 1; i++) {
            dp[i] = k + 1;
        }

        for (int i = 0; i < k + 1; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        int answer = (dp[k] == k + 1) ? -1 : dp[k];
        System.out.print(answer);
    }
}
