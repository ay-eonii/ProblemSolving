package baekjoon.dynamic_programming;

/*
1. 아이디어
- 백트래킹 -> 2^99
- 메모해야할 것 : 경우의 수
- 그럼 결과 확인은 ? -> index로
- 상태 : dp[i][v] = i 번째 숫자까지 계산했을 때, 중간 결과가 v인 경우의 수
2. 시간복잡도
3. 자료구조
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5557 {

    private static int N;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        long[][] dp = new long[N - 1][20 + 1];
        dp[0][numbers[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                int plus = j + numbers[i];
                if (plus >= 0 && plus <= 20) {
                    dp[i][plus] += dp[i - 1][j];
                }
                int minus = j - numbers[i];
                if (minus >= 0 && minus <= 20) {
                    dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N - 2][numbers[N - 1]]);
    }

}
