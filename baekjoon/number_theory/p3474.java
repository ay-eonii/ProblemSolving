package baekjoon.number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3474 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t > 0) {
			long n = Long.parseLong(br.readLine());
			long ret = 0;
			for (long j = 5; j <= n; j *= 5) {
				ret += n / j;
			}

			sb.append(ret + "\n");
			t--;
		}

		System.out.println(sb);
	}
}
