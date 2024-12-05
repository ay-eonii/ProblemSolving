package baekjoon.dynamic_programming;

/*
1. 아이디어
- i에 인사 가능 -> max(i에 인사할 수 있을 만큼 인사했을 때 기쁨 + i 기쁨, 인사안했을 때 기쁨)
- 인사 불가능 -> 인사안했을 때 기쁨
- knapsack
2. 시간복잡도
3. 자료구조
- int[][]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] health = new int[N + 1];
        int[] joy = new int[N + 1];
        String[] h = br.readLine().split(" ");
        String[] j = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            health[i] = Integer.parseInt(h[i - 1]);
            joy[i] = Integer.parseInt(j[i - 1]);
        }

        int[][] dp = new int[N + 1][100];
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y < 100; y++) {
                if (health[x] > y) { // 인사할 수 없음
                    dp[x][y] = dp[x - 1][y];
                } else { // 선택: 지금 인사(이전 인사 안하더라도) vs 지금 인사 안함
                    dp[x][y] = Math.max(dp[x - 1][y - health[x]] + joy[x], dp[x - 1][y]);
                }
            }
        }

        System.out.println(dp[N][99]);
    }
}
