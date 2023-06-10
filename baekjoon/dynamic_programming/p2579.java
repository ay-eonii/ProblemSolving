/* problem
 * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 * */

package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2579 {

    private static int[] stairs;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stairs = new int[n + 1];
        dp = new Integer[n + 1];
        for (int i = 1; i < n + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        System.out.println(find(n));
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + stairs[n - 1]) + stairs[n];
        }
        return dp[n];
    }
}
/*
 * 지금(N) 계단을 밟을려고해
 * 그럼 N-1을 밟았거나 N-2를 밟았을거야
 * 근데 N-1을 밟았다면 그 전에는 N-3을 밟았어야해
 * 즉, 내가 지금 N을 밟으려면 N-1 & N-3 또는 N-2 방법이 있어
 * 추가로, N-3 과 N-2 이전에 뭘 밟았는지는 중요하지 않아.
 * 어차피 2칸을 뛴거니까
 *
 * N-1이 재귀가 아닌 배열의 값을 가져오는 이유?
 * N-1을 재귀해버리면 N-3을 밟았다는 전제가 성립되지 않음...
 * */