package baekjoon.dynamic_programming;

/*
1. 아이디어
- 상태: D까지 오는 최소 거리
2. 시간복잡도
3. 자료구조
- int[]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int D = Integer.parseInt(inputs[1]);

        int[] dp = new int[10_001];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        int[][] shorts = new int[N][3];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            shorts[i][0] = Integer.parseInt(inputs[0]); // start
            shorts[i][1] = Integer.parseInt(inputs[1]); // end
            shorts[i][2] = Integer.parseInt(inputs[2]); // length
        }

        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            for (int j = 0; j < N; j++) {
                if (shorts[j][1] == i) { // 도착지 까지 오는 지름길
                    dp[i] = Math.min(dp[i], dp[shorts[j][0]] + shorts[j][2]);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
