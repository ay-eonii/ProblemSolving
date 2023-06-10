package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1912 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dp = new int[N];

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = num[0];
        int max = num[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
/*
 * 1. 음수를 기준으로 나누기
 * 1-1. 순회하면서 sum에 +=
 * 1-2. 음수 나오면 MAX = MAX < sum ? sum : MAX
 * 2. 음수밖에 없다면 가장 큰 수 1개
 * =========완조니 잘못 생각함===========
 * 음수 껴있어도 젤 클 수 있음
 * 0-0 0-1 0-2 0-3 ... 0-8 0-9 0-10
 * *** 1-1 1-2 1-3 1-4 ... 1-9 1-10
 * *** *** 2-2 2-3 2-4 ... 2-9 2-10
 * 0. 수열 num[]
 * 1. dp[N][N]
 * 2. dp[0] -> dp[0][j] = dp[0][j - 1] + num[j]
 * 3. dp[i][j] = dp[i - 1][j] - num[i - 1]
 * ex. dp[2][9] = dp[1][9] - num[1]
 * =========이것도 아니넴(메모리초과)=============
 * 지금까지 합한거 + 다음 수열 수 < 다음 수열 수 ? 다음 수열부터 다시 더하기
 * */
