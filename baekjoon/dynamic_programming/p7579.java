package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);

		int[] m = new int[N];
		int[] c = new int[N];
		inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(inputs[i]);
		}
		inputs = br.readLine().split(" ");
		int maxCost = 0;
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(inputs[i]);
			maxCost += c[i];
		}

		long[] dp = new long[maxCost + 1];
		for (int i = 0; i < N; i++) {
			for (int cost = maxCost; cost >= c[i]; cost--) {
				dp[cost] = Math.max(dp[cost], dp[cost - c[i]] + m[i]);
			}
		}

		for (int i = 0; i <= maxCost; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				return;
			}
		}
	}
}

// 최소 비용으로 메모리 M
// 합이 M 이상인 최소비용
// 뽑기개수 제한X, 순서 상관X

// 1 ≤ N ≤ 100
// 1 ≤ M ≤ 10,000,000
// dp[cost] = 해당 비용으로 얻을 수 있는 최대 메모리
// dp[cost] = dp[i] + dp[cost-i]
// 앱을 안끈다 : dp[cost]
// 앱을 끈다 : dp[cost-ci] + m[i] (비용 증가 하지 않은 상태(cost-ci)에서 앱 끄기=> + m[i])
// 앱을 끈다는것은 ? 비용이 증가하고, 메모리가 증가함
// 비용 증가 전 상태에서 메모리 증가
// dp 값: 메모리
// dp[비용] = dp[이전비용] + 메모리
