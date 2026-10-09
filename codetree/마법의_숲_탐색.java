import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] tdx = new int[] {0, 1, 0, -1}; // 북동남서 (회전)
	private static final int[] tdy = new int[] {-1, 0, 1, 0};

	private static final int[][][] mdx = {
		{{0, 0, 0,}, {0, 0, 0}}, //북
		{{1, 2, 1}, {-1, 0, 1}}, //동
		{{-1, 0, 1}, {1, 2, 1}}, //남
		{{-1, -2, -1}, {-1, 0, 1}} //서
	};

	private static int R;
	private static int C;
	private static int[][] jr; // 정령 위치
	private static int[][] map; // 골룸위치
	private static int[] door; // 문방향

	// 각 정령들이 최종적으로 위치한 행의 총합
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		jr = new int[K][2]; // 정령 위치
		door = new int[K]; // 문방향
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			// if (map[0][c] != 0 && map[1][c] != 0 && map[]) {
			//     for (int[] m : map) {
			//         Arrays.fill(m, 0);
			//     }
			// }

			jr[i][0] = -2; // 행
			jr[i][1] = c; // 열
			door[i] = d; // 문방향

			// 1. 내려가기
			start(i);
			if (jr[i][0] - 1 < 0) {
				for (int[] m : map) {
					Arrays.fill(m, 0);
				}
				continue;
			}

			place(i);

			// for (int z = 0; z < R; z++) {
			//     for (int j = 0; j <C; j++) {
			//         System.out.printf("%5d ", map[z][j]);
			//     }
			//     System.out.println(" ");
			// }
			// System.out.println();

			// 4. 골룸내에서 이동하기
			answer += dfs(i) + 1;
		}

		System.out.println(answer);
	}

	private static int dfs(int num) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {jr[num][0], jr[num][1]});

		int[][] visited = new int[R][C];
		for (int[] v : visited) {
			Arrays.fill(v, -1);
		}
		visited[jr[num][0]][jr[num][1]] = 0;

		int max = jr[num][0];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[1] + tdx[i];
				int ny = cur[0] + tdy[i];

				if (nx < 0 || nx >= C || ny < 0 || ny >= R || visited[ny][nx] != -1) {
					continue;
				}
				if (map[ny][nx] == 0) {
					continue;
				}
				if (map[cur[0]][cur[1]] < 10000) {
					if (map[ny][nx] != map[cur[0]][cur[1]] && map[cur[0]][cur[1]] != map[ny][nx] - 10000) {
						continue;
					}
				}

				// if (map[ny][nx] > 10000) {
				//     System.out.println("map[ny][nx]: " + map[ny][nx]);
				//     if (map[ny][nx] != map[cur[0]][cur[1]] - 10000) {
				//         continue;
				//     }
				// } else if (map[cur[0]][cur[1]] == map[ny][nx]) {

				// }
				//  else if (map[cur[0]][cur[1]] != map[ny][nx]) {
				//     continue;
				// }

				visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
				q.add(new int[] {ny, nx});
				max = Math.max(max, ny);
			}
		}

		// for (int z = 0; z < R; z++) {
		//     for (int j = 0; j <C; j++) {
		//         System.out.print(visited[z][j] +" ");
		//     }
		//     System.out.println(" ");
		// }
		// System.out.println();

		return max;
	}

	private static void place(int num) {
		// 골룸
		map[jr[num][0]][jr[num][1]] = num + 1;
		for (int i = 0; i < 4; i++) {
			int nx = jr[num][1] + tdx[i];
			int ny = jr[num][0] + tdy[i];
			if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
				continue;
			}

			map[ny][nx] = num + 1; // 골룸간 구분

			if (door[num] == i) {
				map[ny][nx] += 10000; // 문 표시
			}
		}

	}

	private static void start(int num) {
		while (true) {
			if (go(num, 2)) {
				continue;
			}
			if (go(num, 3)) {
				if (!go(num, 2)) {
					go(num, 1);
				} else {
					turn(num, 3);
					continue;
				}
			}
			if (go(num, 1)) {
				if (!go(num, 2)) {
					go(num, 3);
				} else {
					turn(num, 1);
					continue;
				}
			}

			break;
		}
	}

	private static void turn(int num, int d) { // 서쪽
		// 수정
		if (d == 1) {
			door[num] = (door[num] + 1) % 4;
		} else {
			door[num] = (door[num] + 4 - 1) % 4;
		}
	}

	private static boolean go(int num, int d) {
		if (canMove(num, d)) {
			jr[num][0] += tdy[d];
			jr[num][1] += tdx[d];
			return true;
		}
		return false;
	}

	private static boolean canMove(int num, int d) {
		int[] dx = mdx[d][0]; // 행
		int[] dy = mdx[d][1]; // 열

		for (int i = 0; i < 3; i++) {
			int nx = jr[num][1] + dx[i];
			int ny = jr[num][0] + dy[i];

			if (nx < 0 || nx >= C || ny >= R) {
				return false;
			}

			if (ny < 0) {
				continue;
			}

			if (map[ny][nx] != 0) {
				return false;
			}
		}
		return true;
	}
}

// 북동남서
