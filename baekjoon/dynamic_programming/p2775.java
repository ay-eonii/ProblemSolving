package baekjoon.dynamic_programming;

/*
1. 아이디어
- a층 b호 = a층 b-1호 + a-1층 b호 = ...
- 메모이제이션
2. 시간복잡도
3. 자료구조
- dp = int[층][호]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k + 1][n + 1];
            for (int j = 0; j < n + 1; j++) {
                dp[0][j] = j;
            }

            for (int y = 1; y < k + 1; y++) { // 층
                for (int x = 1; x < n + 1; x++) {
                    dp[y][x] = dp[y][x - 1] + dp[y - 1][x];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}
