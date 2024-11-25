package baekjoon.dynamic_programming;

/*
1. 아이디어
- 상태 : N칸 까지 올 수 있는 최단 점프 횟수
- 최적화 : N칸까지 온 최단 점프 횟수 저장
- 선택 : 현재 칸에서 가능한 만큼 점프
2. 시간복잡도
- 1000 * 100 < 1억
3. 자료구조
- int[] jumps
- int[] dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] jumps = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            jumps[i] = Integer.parseInt(inputs[i]);
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            int jump = jumps[i];
            for (int j = 1; j <= jump; j++) {
                if (i + j >= N) {
                    break;
                }
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }

        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }
}
