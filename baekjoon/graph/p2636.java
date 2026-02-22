package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2636 {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		int[][] cheese = new int[N][M];
		int count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) {
					count++;
				}
			}
		}

		if (count == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}

		int turn = 0;
		while (count > 0) {
			turn++;
			bfs(cheese);
			int temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == 1) {
						temp++;
					}
				}
			}
			if (temp == 0) {
				System.out.println(turn);
				System.out.println(count);
			}
			count = temp;
		}
	}

	static void bfs(int[][] cheese) {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) {
					continue;
				}

				visited[ny][nx] = true;
				if (cheese[ny][nx] == 0) {
					q.add(new Point(nx, ny));
				}
				cheese[ny][nx] = 0;
			}
		}
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
