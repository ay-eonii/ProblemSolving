package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15684 {

	private static int ret;
	private static int n;
	private static int h;
	private static boolean[][] visited;
	private static boolean[][] ladder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		ladder = new boolean[h][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			ladder[a][b] = true;
		}

		ret = 4;
		put(0, 0);
		if (ret > 3) {
			ret = -1;
		}
		System.out.println(ret);
	}

	static void put(int count, int y) {
		if (count > 3 || count >= ret) {
			return;
		}

		if (ride()) {
			ret = count;
			return;
		}

		for (int i = y; i < h; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (ladder[i][j] || (j > 0 && ladder[i][j - 1]) || (j < n - 2 && ladder[i][j + 1])) {
					continue;
				}

				ladder[i][j] = true;
				put(count + 1, i);
				ladder[i][j] = false;
			}
		}
	}

	static boolean ride() {
		for (int i = 0; i < n; i++) {
			int line = i;
			for (int j = 0; j < h; j++) {
				if (line != n - 1 && ladder[j][line]) {
					line++;
				} else if (line != 0 && ladder[j][line - 1]) {
					line--;
				}
			}
			if (line != i) {
				return false;
			}
		}
		return true;
	}
}
