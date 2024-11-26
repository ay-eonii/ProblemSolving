package baekjoon.dynamic_programming;

/*
1. 아이디어
- 상태 : 숫자의 길이가 N이면서 앞에 숫자가 M인 숫자의 개수
- -> 상태가 2개, 2차원 배열에 저장
- status[N][M] = N번째 자리수에 숫자 M이 올 수 있는 오르막 경우의 수
- 기저상태: 숫자의 길이가 1이라면 경우의 수는 1 (status[1][M] = 1)
2. 시간복잡도
3. 자료구조
- dp[N][M]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11057 {

    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10];
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += topDown(N, i); // N번째 자리에 숫자 i가 오는 경우의 수의 합
        }

        System.out.println(answer % 10_007);
    }

    public static long topDown(int num, int last) {
        if (num == 1) {
            return dp[num][last] = 1;
        }
        if (dp[num][last] > 0) {
            return dp[num][last];
        }

        long count = 0;
        for (int i = 0; i <= last; i++) {
            count += topDown(num - 1, i) % 10_007;
        }
        return dp[num][last] = count % 10_007;
    }
}
