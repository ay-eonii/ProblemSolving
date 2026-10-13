import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};

	private static char[][] maze;
	private static int N;
	private static int M;

	public int solution(String[] maps) {

		// 격자만들기
		N = maps.length; // y
		M = maps[0].length(); // x
		maze = new char[N][M];

		int[] start = new int[2];
		int[] end = new int[2];
		int[] lever = new int[2];
		for (int i = 0; i < N; i++) {
			String map = maps[i];
			maze[i] = map.toCharArray();
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == 'S') {
					start = new int[] {i, j}; // y,x
				}
				if (maze[i][j] == 'L') {
					lever = new int[] {i, j}; // y,x
				}
				if (maze[i][j] == 'E') {
					end = new int[] {i, j}; // y,x
				}
			}
		}

		// 시작 -> 레버 : bfs. 도달할 수 없으면 -1
		int d1 = bfs(start, lever);
		if (d1 == -1) {
			return -1;
		}

		// 레버 -> 문 : bfs. 도달할 수 없으면 -1
		int d2 = bfs(lever, end);
		if (d2 == -1) {
			return -1;
		}

		return d1 + d2;
	}

	public int bfs(int[] start, int[] end) {
		int[][] visited = new int[N][M];
		Queue<int[]> q = new ArrayDeque<>();

		for (int[] v : visited) {
			Arrays.fill(v, -1);
		}
		visited[start[0]][start[1]] = 0;
		q.add(start);

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[1] + dx[i];
				int ny = cur[0] + dy[i];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx] != -1) {
					continue;
				}

				if (maze[ny][nx] == 'X') {
					continue;
				}

				visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
				q.add(new int[] {ny, nx});
			}
		}

		return visited[end[0]][end[1]];
	}
}

// 1. 시작 -> 레버
// 2. 레버 -> 문
// 최단거리 : bfs
// 탈출할 수 없다면 -1
