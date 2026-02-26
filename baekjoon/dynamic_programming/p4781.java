package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4781 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = br.readLine();
			if (input.equals("0 0.00")) {
				break;
			}
			String[] split = input.split(" ");
			int n = Integer.parseInt(split[0]);
			int m = (int)(Double.parseDouble(split[1]) * 100 + 0.5);

			int[] dp = new int[m + 1];
			for (int i = 0; i < n; i++) {
				split = br.readLine().split(" ");
				int c = Integer.parseInt(split[0]);
				int p = (int)(Double.parseDouble(split[1]) * 100 + 0.5);

				for (int j = p; j <= m; j++) {
					if (j >= p) {
						dp[j] = Math.max(dp[j], dp[j - p] + c);
					}
				}
			}

			System.out.println(dp[m]);
		}
	}
}
