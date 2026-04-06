package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p14502 {

	private final static int[] dx = {0, 0, -1, 1};
	private final static int[] dy = {-1, 1, 0, 0};
	private static boolean[][] visited;
	private static int[][] map;
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		List<int[]> virus = new ArrayList<>();
		List<int[]> wall = new ArrayList<>();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
				if (map[i][j] == 0) {
					wall.add(new int[] {i, j});
				}
			}
		}

		visited = new boolean[n][m];
		int max = 0;
		for (int i = 0; i < wall.size(); i++) {
			for (int j = 0; j < i; j++) {
				for (int k = 0; k < j; k++) {
					for (boolean[] v : visited) {
						Arrays.fill(v, false);
					}
					int[] f = wall.get(i);
					int[] s = wall.get(j);
					int[] t = wall.get(k);
					map[f[0]][f[1]] = 1;
					map[s[0]][s[1]] = 1;
					map[t[0]][t[1]] = 1;
					for (int[] v : virus) {
						dfs(v[1], v[0]);
					}
					max = Math.max(countSafe(), max);
					map[f[0]][f[1]] = 0;
					map[s[0]][s[1]] = 0;
					map[t[0]][t[1]] = 0;
				}
			}
		}

		System.out.println(max);
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx] != 0) {
				continue;
			}

			if (!visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(nx, ny);
			}
		}
	}

	static int countSafe() {
		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					ret++;
				}
			}
		}
		return ret;
	}
}
