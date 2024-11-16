package baekjoon.dynamic_programming;

/*
1. 아이디어
- 상태 : N자리 이진수
- 선택 : 0/1
2. 시간복잡도
- 완전탐색 -> 90만 자리수 시간초과
- dp -> O(N)
3. 자료구조
- long[]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 2) {
            System.out.print(1);
            return;
        }

        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.print(dp[N]);
    }
}
