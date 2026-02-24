package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14620 {

	private static final int[] dx = {0, 0, 0, -1, 1};
	private static final int[] dy = {0, -1, 1, 0, 0};
	private static int ret;
	private static int n;
	private static int[][] garden;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		garden = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ret = Integer.MAX_VALUE;
		visited = new boolean[n][n];
		go(0, 1, 0);

		System.out.println(ret);
	}

	static void go(int count, int y, int cost) {
		if (cost >= ret) {
			return;
		}

		if (count == 3) {
			ret = Math.min(cost, ret);
			return;
		}

		for (int i = y; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (check(j, i)) {
					continue;
				}

				int extra = plant(j, i, true);
				go(count + 1, i, cost + extra);
				plant(j, i, false);
			}
		}
	}

	static boolean check(int j, int i) {
		for (int k = 0; k < 5; k++) {
			int nx = j + dx[k];
			int ny = i + dy[k];
			if (visited[ny][nx]) {
				return true;
			}
		}

		return false;
	}

	static int plant(int j, int i, boolean value) {
		int cost = 0;
		for (int k = 0; k < 5; k++) {
			int nx = j + dx[k];
			int ny = i + dy[k];
			visited[ny][nx] = value;
			cost += garden[ny][nx];
		}
		return cost;
	}
}
