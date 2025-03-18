package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= k; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        System.out.println(dp[k]);
    }
}

/**
 * 상태 : 사용한 동전, 동전 가치의 합
 * - 왜 상태에 사용한 동전이 들어가나 ?????
 * => 동전 i의 사용 여부에 따라 경우를 구분해서 순서가 다른 경우라도 같은 조합을 한 번만 세도록 보장해야함
 * 선택 : 현재 동전을 사용할지 말지
 * - 동전 미사용: 이전 동전들(c - 1)만 사용해 k 만들기 = dp[c - 1][k]
 * - 동전 사용: 현재 동전(c)을 사용할 수 있는 경우에 현재 동전 추가하기 = dp[c][k-v[i]]
 * <p>
 * 메모리 초과
 * - 동전 미사용: dp[k]
 * - 동전 사용: dp[k-v[i]]
 * => dp[k] + dp[k-v[i]]
 */
