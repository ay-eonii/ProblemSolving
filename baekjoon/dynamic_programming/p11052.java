package baekjoon.dynamic_programming;

/*
1. 아이디어
2. 시간복잡도
3. 자료구조
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pack = new int[N + 1];
        String[] inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            pack[i] = Integer.parseInt(inputs[i - 1]);
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + pack[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
