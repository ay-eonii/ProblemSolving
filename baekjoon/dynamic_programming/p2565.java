package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p2565 {

    private static int[][] wire;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        wire = new int[N][2];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                wire[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(recur(i), max);
        }

        System.out.println(N - max);
    }

    private static int recur(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;
            for (int i = n + 1; i < dp.length; i++) {
                if (wire[n][1] < wire[i][1]) {
                    dp[n] = Math.max(dp[n], recur(i) + 1);
                }
            }
        }
        return dp[n];
    }
}

/*
- 문제 이해
1. 이어진 전깃줄이 교차하지 않도록 최소한의 전깃줄을 제거해야 한다

- strategy
1. 교차하는 경우: i < j && A[i] > A[j]
2. 교차안되도록 설치 -> 설치 가능한 최대 개수 구하기
 */
