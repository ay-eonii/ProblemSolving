package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2529 {

	private static long max = 0;
	private static long min = Long.MAX_VALUE;
	private static int k;
	private static String[] op;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		op = new String[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			op[i] = st.nextToken();
		}

		visited = new boolean[10];

		for (int i = 0; i < 10; i++) {
			visited[i] = true;
			dfs(i + "");
			visited[i] = false;
		}

		String format = "%0" + (k + 1) + "d\n";
		System.out.printf(format, max);
		System.out.printf(format, min);
	}

	static void dfs(String num) {
		if (num.length() == k + 1) {
			max = Math.max(max, Long.parseLong(num));
			min = Math.min(min, Long.parseLong(num));
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visited[i]) {
				continue;
			}

			int last = Integer.parseInt(num.split("")[num.length() - 1]);
			if ((">".equals(op[num.length() - 1]) && last > i) || ("<".equals(op[num.length() - 1])
				&& last < i)) {
				visited[i] = true;
				dfs(num + i);
				visited[i] = false;
			}
		}
	}
}
