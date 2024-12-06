package baekjoon.dynamic_programming;

/*
1. 아이디어
- n자리 수일 때 줄들지 않는 수의 개수
- 마지막수가 i로 고정인 경우
- n-1자리 수일때 경우의 수 (마지막 1부터 n까지)
- 점화식: dp[i][n] = dp[i-1][n] + dp[i][n-1]
- 경우의수 : dp[0][n] + ... dp[9][n]
2. 시간복잡도
3. 자료구조
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2688 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            long[][] dp = new long[10][65];
            for (int i = 1; i < 65; i++) {
                dp[0][i] = 1;
            }
            for (int i = 0; i < 10; i++) {
                dp[i][0] = 1;
            }

            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < 10; j++) {
                    dp[j][i] = dp[j][i - 1] + dp[j - 1][i];
                }
            }

            long answer = 0;
            for (int i = 0; i < 10; i++) {
                answer += dp[i][n - 1];
            }

            System.out.println(answer);
        }
    }
}
