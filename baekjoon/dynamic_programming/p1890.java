package baekjoon.dynamic_programming;

/*
1. 아이디어
- bfs -> 가다보면 동일한 지점에서 만남 -> 메모이제이션
- dp : topdown
2. 시간복잡도
3. 자료구조
- int[][] dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1890 {

    private static long[][] dp;
    private static int[][] map;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                dp[i][j] = -1;
            }
        }

        topdown(0, 0);

        System.out.println(dp[0][0]);
    }

    public static long topdown(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        int jump = map[y][x];
        dp[y][x] = 0;

        if (y + jump < N) {
            dp[y][x] += dp[y + jump][x] = topdown(x, y + jump);
        }
        if (x + jump < N) {
            dp[y][x] += dp[y][x + jump] = topdown(x + jump, y);
        }

        return dp[y][x];
    }
}
