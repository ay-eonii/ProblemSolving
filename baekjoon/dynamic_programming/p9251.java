package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9251 {

    private static Integer[][] dp;
    private static char[] arr1;
    private static char[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();
        dp = new Integer[arr1.length][arr2.length];


        System.out.println(LCS(arr1.length - 1, arr2.length - 1));
    }

    private static int LCS(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (arr1[x] == arr2[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }

        return dp[x][y];
    }
}

