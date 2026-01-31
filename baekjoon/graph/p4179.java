package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p4179 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int R;
	static int C;
	static String[][] MAP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]); //행
		C = Integer.parseInt(input[1]); //열
		MAP = new String[R][C];
		Point jihun = null;
		List<Point> fire = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				if ("J".equals(input[j])) {
					jihun = new Point(j, i);
				} else if ("F".equals(input[j])) {
					fire.add(new Point(j, i));
				}
				MAP[i][j] = input[j];
			}
		}

		// 지훈 최단
		List<Point> list = new ArrayList<>(List.of(jihun));
		int[][] jihunMap = bfs(list);

		// 불 최단
		int[][] fireMap = bfs(fire);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (j == 0 || j == C - 1 || i == 0 || i == R - 1) {
					if (jihunMap[i][j] < fireMap[i][j] && jihunMap[i][j] != -1) {
						min = Math.min(jihunMap[i][j], min);
					}
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(min + 1);
		}
	}

	static int[][] bfs(List<Point> points) {
		int[][] visited = new int[R][C];
		for (int[] v : visited) {
			Arrays.fill(v, Integer.MAX_VALUE);
		}

		for (Point p : points) {
			visited[p.y][p.x] = 0;
		}
		Queue<Point> q = new LinkedList<>(points);
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= C || ny < 0 || ny >= R || visited[ny][nx] != Integer.MAX_VALUE) {
					continue;
				}

				if (".".equals(MAP[ny][nx]) || "J".equals(MAP[ny][nx])) {
					visited[ny][nx] = visited[now.y][now.x] + 1;
					q.add(new Point(nx, ny));
				}
			}
		}
		return visited;
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
