package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1926 {
	private static final int[] dx = {0, 0, -1, 1};// 상하좌우
	private static final int[] dy = {1, -1, 0, 0};// 상하좌우
	private static int[][] paper;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	private static int maxSize = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]); // 열
		m = Integer.parseInt(inputs[1]); // 행
		paper = new int[n][m];
		visited = new boolean[n][m];

		for (int y = 0; y < n; y++) {
			String[] split = br.readLine().split(" ");
			for (int x = 0; x < m; x++) {
				paper[y][x] = Integer.parseInt(split[x]);
			}
		}

		int count = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (!visited[y][x] && paper[y][x] == 1) {
					count++;
					bfs(x, y);
				}
			}
		}

		System.out.println(count);
		System.out.println(maxSize);
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[y][x] = true;

		int size = 0;
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			size++;
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx] || paper[ny][nx] == 0) {
					continue;
				}
				queue.add(new Point(nx, ny));
				visited[ny][nx] = true;
			}
		}

		maxSize = Math.max(maxSize, size);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

// strategy
// bfs
