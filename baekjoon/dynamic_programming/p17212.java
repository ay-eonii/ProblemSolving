package baekjoon.dynamic_programming;

/*
1. 아이디어
- 동전문제
- dp
2. 시간복잡도
3. 자료구조
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17212 {

    private static final int[] coins = {1, 2, 5, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    break;
                }
                int left = i - coin;
                dp[i] = Math.min(dp[left] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
