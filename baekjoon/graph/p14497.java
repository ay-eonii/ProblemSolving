package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14497 {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};
	private static int n;
	private static int m;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int count = 1;
		if (x1 == x2 && y1 == y2) {
			System.out.println(count);
			return;
		}

		while (!bfs(x1, y1)) {
			count++;
		}
		System.out.println(count);
	}

	static boolean bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		boolean[][] visited = new boolean[n][m];

		while (!q.isEmpty()) {
			Point here = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = here.x + dx[i];
				int ny = here.y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] == '#') {
					return true;
				} else if (map[nx][ny] == '1') {
					map[nx][ny] = 0;
					visited[nx][ny] = true;
				} else {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny, here.count));
				}
			}
		}
		return false;
	}

	static class Point {
		int x;
		int y;
		int count;

		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
