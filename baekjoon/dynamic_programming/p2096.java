package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][3];
        for (int y = 1; y <= n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 3; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] minDp = new int[n + 1][3];
        int[][] maxDp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0];
            maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1];
            maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2];

            minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0];
            minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1];
            minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2];
        }

        int min = 900_000;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[n][i]);
            max = Math.max(max, maxDp[n][i]);
        }

        System.out.print(max + " " + min);
    }
}

// strategy
// 브루트포스
// dfs
// 종료조건: 끝까지 내려왔을 때 -> y == n
// 이동조건: (x,y) -> (x, y+1) or (x-1,y+1) or (x+1,y+1)
// 시작점 : (0, 0) ... (n-1, 0)
// -- 메모리초과---
// dp
