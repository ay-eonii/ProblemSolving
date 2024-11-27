package baekjoon.dynamic_programming;

/*
1. 아이디어
- dp 반대
- 기저상태 : dp[][첫날] = {1},{0}, dp[][둘째날] = {0},{1}
- 점화식 (첫날,둘째날이 몇개인지):
    dp[0][6] = dp[0][4] + dp[0][5]
    dp[1][6] = dp[1][4] + dp[1][5]
    => dp[][N] = dp[][N-1] + dp[][N-2]
- 메모할 것 : 1일차, 2일차 각 몇개인지
2. 시간복잡도
3. 자료구조
- int[2(1일차, 2일차)][일차몇번]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2502 {

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int D = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        dp = new int[2][D + 1];
        dp[0][1] = dp[1][2] = 1; //첫날, 둘째날
        for (int i = 3; i < D + 1; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
            dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
        }

        int firstDayCount = dp[0][D];
        int secondDayCount = dp[1][D];

        int a = 1;
        while ((K - (a * firstDayCount)) % secondDayCount != 0) {
            a++;
        }

        int b = (K - (a * firstDayCount)) / secondDayCount;

        System.out.println(a);
        System.out.println(b);
    }
}
