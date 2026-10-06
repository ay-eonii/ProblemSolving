import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, -1, 1, 0};
	private static final int[] dy = {-1, 0, 0, 1};
	private static final int BASE_CAMP = 1;

	private static int[][] convenients;
	private static int[][] people;
	private static int[][] map;
	private static int[][] visited;
	private static int left;
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		convenients = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			convenients[i][0] = Integer.parseInt(st.nextToken()) - 1; // 행
			convenients[i][1] = Integer.parseInt(st.nextToken()) - 1; // 열
		}

		left = m;
		people = new int[m][2];
		for (int i = 0; i < m; i++) {
			people[i][0] = -1;
			people[i][1] = -1;
		}

		int minutes = 0;
		visited = new int[n][n];
		while (left > 0) {
			minutes++;
			// 1. 격자 사람 이동
			move();
			// 2. 편의점 도착했다면 칸 블락
			arrive();
			// 3. 첫 베이스캠프 이동 후 칸 블락
			goBaseCamp(minutes);
		}
		System.out.println(minutes);
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void arrive() {
		for (int i = 0; i < m; i++) {
			int py = people[i][0];
			int px = people[i][1];

			int cy = convenients[i][0];
			int cx = convenients[i][1];

			if (cx == px && cy == py) {
				left--;
				people[i][0] = -1;
				people[i][1] = -1;
				map[cy][cx] = -1;
			}
		}
	}

	private static void move() {
		for (int i = 0; i < m; i++) {
			int py = people[i][0];
			int px = people[i][1];

			if (px == -1 || py == -1) {
				continue;
			}

			Point point = bfs(px, py, i, false);

			// 역추적
			while (point.before != null) {
				if (point.before.before == null) {
					break;
				}
				point = point.before;
			}

			people[i][0] = point.y;
			people[i][1] = point.x;
		}
	}

	public static void goBaseCamp(int minutes) {
		if (minutes > m) {
			return;
		}

		int idx = minutes - 1;

		int cy = convenients[idx][0];
		int cx = convenients[idx][1];

		Point baseCamp = bfs(cx, cy, BASE_CAMP, true);
		map[baseCamp.y][baseCamp.x] = -1;
		people[idx][0] = baseCamp.y;
		people[idx][1] = baseCamp.x;
	}

	private static Point bfs(int x, int y, int target, boolean isBaseCamp) {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], -1);
		}

		Queue<Point> q = new ArrayDeque<>();
		Point point = new Point(x, y, null);
		q.add(point);
		Point nearest = new Point(n - 1, n - 1, null);
		visited[y][x] = 0;
		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx] != -1) {
					continue;
				}

				if (map[ny][nx] == -1) {
					continue;
				}

				visited[ny][nx] = visited[cur.y][cur.x] + 1;
				q.add(new Point(nx, ny, cur));

				if (isBaseCamp && target == map[ny][nx]) {
					if (min > visited[ny][nx]) {
						nearest = new Point(nx, ny, cur);
					} else if (min == visited[ny][nx]) {
						if (ny < nearest.y) {
							nearest = new Point(nx, ny, cur);
						} else if (ny == nearest.y) {
							if (nx < nearest.x) {
								nearest = new Point(nx, ny, cur);
							}
						}
					}
					min = Math.min(min, visited[ny][nx]);
				}

				if (!isBaseCamp) {
					int cy = convenients[target][0];
					int cx = convenients[target][1];
					if (ny == cy && nx == cx) {
						return new Point(nx, ny, cur);
					}
				}
			}
		}

		return nearest;
	}

	public static class Point {
		int x;
		int y;
		Point before;

		public Point(int x, int y, Point before) {
			this.x = x;
			this.y = y;
			this.before = before;
		}
	}
}
