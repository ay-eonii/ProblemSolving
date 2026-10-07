import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};
	private static final int[] attacker = new int[2];
	private static final int[] defenser = new int[2];
	private static int n;
	private static int m;
	private static int k;
	private static int[][] history;
	private static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		history = new int[n][m];
		visited = new int[n][m];
		int t = k;
		k = 1;
		while (t > 0) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] > 0) {
						count++;
					}
				}
			}

			if (count <= 1) {
				break;
			}

			// 1. 공격자, 수비자 선정
			choose(map);
			// 2. 공격
			List<int[]> war = attack(map);

			// 3. 공격력 계산
			update(map, war);
			t--;
			k++;
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, map[i][j]);
			}
		}

		System.out.println(max);
	}

	private static void update(int[][] map, List<int[]> war) {
		int len = war.size();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] <= 0) {
					continue;
				}
				boolean flag = false;
				for (int w = 0; w < len; w++) {
					if (war.get(w)[0] == i && war.get(w)[1] == j) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					map[i][j]++;
				}
			}
		}
	}

	private static List<int[]> attack(int[][] map) {
		int aty = attacker[0];
		int atx = attacker[1];
		int dfy = defenser[0];
		int dfx = defenser[1];

		Point point = bfs(atx, aty, dfx, dfy, map);

		// 수비자 공격
		int attack = map[aty][atx];
		map[dfy][dfx] -= attack;

		List<int[]> war = new ArrayList<>();
		war.add(new int[] {aty, atx});
		war.add(new int[] {dfy, dfx});

		if (visited[dfy][dfx] != -1) { // 레이저
			// 경로 탑 공격
			while (point.before != null) {
				point = point.before;
				if (point.y == aty && point.x == atx) {
					break;
				}
				map[point.y][point.x] -= attack / 2;
				war.add(new int[] {point.y, point.x});
			}
		} else { // 포탄
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					// 수비자, 공격자 제외
					int x = (dfx + m + i) % m;
					int y = (dfy + n + j) % n;

					if ((x == dfx && y == dfy) || (x == atx && y == aty)) {
						continue;
					}

					map[y][x] -= attack / 2;
					war.add(new int[] {y, x});
				}
			}
		}

		return war;
	}

	private static Point bfs(int atx, int aty, int dfx, int dfy, int[][] map) {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], -1);
		}

		Queue<Point> q = new ArrayDeque<>();
		Point ret = new Point(atx, aty, null);
		q.add(ret);
		visited[aty][atx] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = (cur.x + m + dx[i]) % m;
				int ny = (cur.y + n + dy[i]) % n;

				if (visited[ny][nx] != -1) {
					continue;
				}

				// 무너진포탑
				if (map[ny][nx] <= 0) {
					continue;
				}

				visited[ny][nx] = visited[cur.y][cur.x] + 1;
				q.add(new Point(nx, ny, cur));

				if (dfx == nx && dfy == ny) {
					return new Point(nx, ny, cur);
				}
			}
		}

		return ret;
	}

	private static void choose(int[][] map) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		attacker[0] = 0;
		attacker[1] = 0;
		defenser[0] = n;
		defenser[1] = m;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] <= 0) {
					continue;
				}

				// 공격자
				if (map[i][j] < min) {
					min = map[i][j];
					attacker[0] = i;
					attacker[1] = j;
				} else if (map[i][j] == min) {
					if (history[i][j] > history[attacker[0]][attacker[1]]) {
						attacker[0] = i;
						attacker[1] = j;
					} else if (history[i][j] == history[attacker[0]][attacker[1]]) {
						if (i + j > attacker[0] + attacker[1]) {
							attacker[0] = i;
							attacker[1] = j;
						} else if (i + j == attacker[0] + attacker[1]) {
							if (j > attacker[1]) {
								attacker[0] = i;
								attacker[1] = j;
							}
						}
					}
				}

				// 수비자
				if (map[i][j] > max) {
					max = map[i][j];
					defenser[0] = i;
					defenser[1] = j;
				} else if (map[i][j] == max) {
					if (history[i][j] < history[defenser[0]][defenser[1]]) {
						defenser[0] = i;
						defenser[1] = j;
					} else if (history[i][j] == history[defenser[0]][defenser[1]]) {
						if (i + j < defenser[0] + defenser[1]) {
							defenser[0] = i;
							defenser[1] = j;
						} else if (i + j == defenser[0] + defenser[1]) {
							if (j < defenser[1]) {
								defenser[0] = i;
								defenser[1] = j;
							}
						}
					}
				}
			}
		}

		// 공격자 기록
		history[attacker[0]][attacker[1]] = k;

		// 공격력 상승
		map[attacker[0]][attacker[1]] += n + m;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
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

// 남은 포탑 중 가장 강한 포탑 출력
