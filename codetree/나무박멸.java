import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final int[] ddx = {-1, 1, -1, 1};
	private static final int[] ddy = {-1, -1, 1, 1};
	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};
	private static final int WALL = -100;
	private static int answer = 0;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 격자크기
		int m = Integer.parseInt(st.nextToken()); // 박멸 횟수
		int k = Integer.parseInt(st.nextToken()); // 제초제 확산 범위
		int c = Integer.parseInt(st.nextToken()); // 제초제 유지기간

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					map[i][j] = WALL; // 벽을 -100으로 사용. 제초제 유지기간을 음수로 사용
				}
			}
		}

		for (int t = 0; t < m; t++) {
			// 1. 나무 성장
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] <= 0) {
						continue;
					} else {
						for (int d = 0; d < 4; d++) {
							int nx = j + dx[d];
							int ny = i + dy[d];
							if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[ny][nx] <= 0) {
								continue;
							}
							map[i][j]++;
						}
					}
				}
			}

			// 2. 나무 번식
			int[][] growth = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] <= 0) {
						continue;
					}

					int count = 0;

					for (int d = 0; d < 4; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[ny][nx] != 0) {
							continue;
						}
						count++;
					}

					if (count == 0) {
						continue;
					}

					int devide = map[i][j] / count;

					for (int d = 0; d < 4; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[ny][nx] != 0) {
							continue;
						}

						growth[ny][nx] += devide;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] += growth[i][j];
				}
			}

			// 3. 제초제 효과 갱신
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != WALL && map[i][j] < 0) {
						map[i][j]++;
					}
				}
			}

			// 4. 제초제 위치 선점
			int max = 0;
			int x = 0;
			int y = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] <= 0) {
						continue;
					}
					int tmp = map[i][j];
					for (int d = 0; d < 4; d++) {
						int nx = j + ddx[d];
						int ny = i + ddy[d];

						if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[ny][nx] <= 0) {
							continue;
						}
						tmp += findMax(map, k - 1, nx, ny, d);
					}
					if (tmp > max) {
						max = tmp;
						x = j;
						y = i;
					}
				}
			}

			if (max == 0) {
				continue;
			}

			// 5. 제초제 뿌리기 & 박멸 나무 수 합산
			answer += map[y][x];
			map[y][x] = -c;
			for (int d = 0; d < 4; d++) {
				int nx = x + ddx[d];
				int ny = y + ddy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[ny][nx] == WALL) {
					continue;
				}
				kill(map, k - 1, nx, ny, d, c);
			}
		}

		System.out.println(answer);
	}

	private static void kill(int[][] map, int k, int x, int y, int d, int c) {
		if (map[y][x] > 0) {
			answer += map[y][x];
			map[y][x] = -c;
		} else {
			map[y][x] = -c;
			return;
		}

		if (k == 0) {
			return;
		}

		int nx = x + ddx[d];
		int ny = y + ddy[d];

		if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[ny][nx] == WALL) {
			return;
		}

		kill(map, k - 1, nx, ny, d, c);
	}

	private static int findMax(int[][] map, int k, int x, int y, int d) {
		int ret = map[y][x];
		if (k == 0) {
			return ret;
		}

		int nx = x + ddx[d];
		int ny = y + ddy[d];

		if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[ny][nx] <= 0) {
			return ret;
		}

		ret += findMax(map, k - 1, nx, ny, d);
		return ret;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}
}
