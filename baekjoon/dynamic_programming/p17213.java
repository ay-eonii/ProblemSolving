package baekjoon.dynamic_programming;

/*
1. 아이디어
- 상태 : N개 종류에서 M개 훔치는 경우의 수
- n 종류 과일사용해서 m-1 개 훔치기 -> 1개 더 훔치기 == dp[n][m-1]
- n-1 종류 과일사용해서 m-1 개 훔치기 -> 새로운 종류 1개 더 훔치기 == dp[n-1][m-1]
2. 시간복잡도
3. 자료구조
- int[][]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 종류
        int M = Integer.parseInt(br.readLine()); // 개수

        int[][] dp = new int[11][31];
        for (int i = 1; i <= M; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i < N + 1; i++) {
            for (int j = i; j < M + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }

        System.out.println(dp[N][M]);
    }
}
