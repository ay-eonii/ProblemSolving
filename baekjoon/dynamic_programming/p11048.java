package baekjoon.dynamic_programming;

/*
1. 아이디어
- 최댓값을 구하기 -> 완전 탐색
- 하위 문제로 상위 문제 해결 -> 최적화 가능 -> dp
2. 시간복잡도
3. 자료구조
- int[][] maze
- int[][] dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[][] maze = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) { // 행
            inputs = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) { // 열
                maze[i][j] = Integer.parseInt(inputs[j - 1]);
            }
        }

        for (int i = 1; i <= N; i++) { // 행
            for (int j = 1; j <= M; j++) { // 열
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + maze[i][j];
            }
        }

        System.out.println(dp[N][M]);
    }
}
