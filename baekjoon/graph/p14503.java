package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class p14503 {
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {-1, 0, 1, 0};
	private static int n, m;
	private static int[][] room;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);

		inputs = br.readLine().split(" ");
		int r = Integer.parseInt(inputs[0]); // 행
		int c = Integer.parseInt(inputs[1]); // 열
		int d = Integer.parseInt(inputs[2]);

		room = new int[n][m];
		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		System.out.println(clean(c, r, d));
	}

	public static int clean(int x, int y, int d) {
		Deque<Point> stack = new ArrayDeque<>();
		stack.push(new Point(x, y, d));
		room[y][x] = 2; // 청소한 곳은 2로 표시
		int cleanedCount = 1;

		while (!stack.isEmpty()) {
			Point current = stack.pop();
			boolean flag = false;
			int nd = current.d;
			for (int i = 1; i <= 4; i++) {
				nd = (nd + 3) % 4;  // 왼쪽 방향으로 회전
				int nx = current.x + dx[nd];
				int ny = current.y + dy[nd];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
					continue;
				}

				if (room[ny][nx] == 0) { // 청소되지 않은 곳
					room[ny][nx] = 2; // 청소 표시
					cleanedCount++;
					stack.push(new Point(nx, ny, nd));
					flag = true;
					break;
				}
			}

			if (flag) {
				continue;
			}

			nd = (current.d + 2) % 4;
			int nx = current.x + dx[nd];
			int ny = current.y + dy[nd];
			if (nx < 0 || nx >= m || ny < 0 || ny >= n || room[ny][nx] == 1) {
				break;
			}
			stack.push(new Point(nx, ny, current.d));
		}

		return cleanedCount;
	}

	private static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
