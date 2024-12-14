package baekjoon.dynamic_programming;

/*
1. 아이디어
- 선택 : N 번째 사람이 악수를 한다 / 안한다
- 악수를 안한다 -> dp[n-1] == 마지막 사람 없는 상태
- 악수를 한다 -> dp[n-2] == 마지막 2사람 없는 상태
- 점화식: dp[N] = dp[N-1] + dp[N-2]
- 마지막 자리만 출력한다 -> % 10
2. 시간복잡도
3. 자료구조
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8394 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N == 1) {
            System.out.println(1);
            return;
        }

        if (N == 2) {
            System.out.println(2);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10;
        }

        System.out.println(dp[N]);
    }
}
