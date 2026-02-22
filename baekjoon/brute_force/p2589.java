package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p2589 {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};
	private static int n;
	private static int m;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					max = Math.max(bfs(i, j), max);
				}
			}
		}

		System.out.println(max);
	}

	static int bfs(int y, int x) {
		int ret = 0;
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		q.add(new Point(x, y, 0));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point here = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = here.x + dx[i];
				int ny = here.y + dy[i];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == 'L') {
					q.add(new Point(nx, ny, here.d + 1));
					ret = Math.max(ret, here.d + 1);
					visited[ny][nx] = true;
				}
			}
		}

		return ret;
	}

	static class Point {
		int x;
		int y;
		int d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
