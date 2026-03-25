package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2573 {

	private final static int[] dx = {0, 0, -1, 1};
	private final static int[] dy = {-1, 1, 0, 0};
	private static int[][] map;
	private static int n;
	private static int m;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];

		int year = 0;
		while (true) {
			for (boolean[] m : visited) {
				Arrays.fill(m, false);
			}

			int count = 0;
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						dfs(j, i);
						count++;
					}
				}
			}

			if (count >= 2) {
				System.out.println(year);
				return;
			}

			if (count == 0) {
				System.out.println(0);
				return;
			}

			go();
			year++;
		}
	}

	static void go() {
		int[][] melt = new int[n][m];
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				for (int z = 0; z < 4; z++) {
					int nx = j + dx[z];
					int ny = i + dy[z];
					if (map[ny][nx] == 0) {
						melt[i][j]++;
					}
				}
			}
		}

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				map[i][j] = Math.max(0, map[i][j] - melt[i][j]);
			}
		}
	}

	static void dfs(int x, int y) {
		visited[y][x] = true;
		if (map[y][x] == 0) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx]) {
				continue;
			}

			if (map[ny][nx] != 0) {
				dfs(nx, ny);
			}
		}
	}
}
