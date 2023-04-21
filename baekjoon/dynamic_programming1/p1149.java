package baekjoon.dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1149 {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    private static int[][] dp;
    private static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        cost = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        int answer = Math.min(rgb(N - 1, Red), Math.min(rgb(N - 1, Green), rgb(N - 1, Blue)));
        System.out.println(answer);
    }

    private static int rgb(int N, int color) {
        if (dp[N][color] == 0) {
            if (color == Red) {
                dp[N][Red] = Math.min(rgb(N - 1, Green), rgb(N - 1, Blue)) + cost[N][Red];
            } else if (color == Green) {
                dp[N][Green] = Math.min(rgb(N - 1, Red), rgb(N - 1, Blue)) + cost[N][Green];
            } else {
                dp[N][Blue] = Math.min(rgb(N - 1, Red), rgb(N - 1, Green)) + cost[N][Blue];
            }
        }
        return dp[N][color];
    }
}