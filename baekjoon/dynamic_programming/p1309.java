package baekjoon.dynamic_programming;

/*
1. 아이디어
- 상태: 우리 길이가 N, 앞 우리에 사자를 넣었는지 또는 어디에 넣었는지(0,1,2)
=> 상태가 2개 -> 2차원 배열 ([우리 길이][3(안넣음, 왼쪽에 넣음, 오른쪽에 넣음)
2. 시간복잡도
3. 자료구조
- long[][] dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][3];
        for (int i = 0; i < 3; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += dp[N][i] % 9901;
        }

        System.out.println(answer % 9901);
    }
}
