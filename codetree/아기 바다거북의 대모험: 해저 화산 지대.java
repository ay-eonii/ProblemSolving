import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};

	private static int N;
	private static int M;
	private static int K;
	private static int turn;

	private static int[] answer;
	private static int[] pressure;
	private static boolean[] v;
	private static int[][] map;
	private static int[][] turtles;
	private static int[][] mountains;
	private static int[][] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //격자크기
		M = Integer.parseInt(st.nextToken()); //바다거북 수
		K = Integer.parseInt(st.nextToken()); //해저화산 수

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 0: 빈공간, 1: 산호초
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		turtles = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			turtles[i][0] = Integer.parseInt(st.nextToken()); // y
			turtles[i][1] = Integer.parseInt(st.nextToken()); // x
		}

		mountains = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			mountains[i][0] = Integer.parseInt(st.nextToken()); // y
			mountains[i][1] = Integer.parseInt(st.nextToken()); // x
			mountains[i][2] = Integer.parseInt(st.nextToken()); // 임계
		}

		pressure = new int[K];

		turn = 1;
		answer = new int[M];
		while (turn <= 100) {
			// System.out.println("turn " + turn );
			// 1. 바다거북이동
			move();

			// 2. 화산 압력 증가
			for (int i = 0; i < K; i++) {
				pressure[i] += 10;
			}

			// 3. 화산 분출 및 연쇄 반응
			v = new boolean[K]; // 분출여부
			sum = new int[N][N];
			spread();
			fire();
			die();

			// 4. 환경 초기화
			for (int i = 0; i < K; i++) {
				if (v[i]) {
					pressure[i] = 0;
				}
			}
			turn++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if (answer[i] == 0) {
				sb.append(-1).append("\n");
			} else {
				sb.append(answer[i]).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static void die() {
		// System.out.println("heat");
		// print(sum);

		// 살아있는 거북이 -> 열기 20넘으면 화석
		for (int i = 0; i < M; i++) {
			int ty = turtles[i][0];
			int tx = turtles[i][1];
			if (answer[i] == 0 && sum[ty][tx] >= 20) {
				map[ty][tx] = -1;
				turtles[i][0] = -1;
				turtles[i][1] = -1;
				answer[i] = -1;
			}
		}
		// System.out.println("turtles");
		// print(turtles);
	}

	// 1. 임계치 이상 분출
	// 2. 열기로 인해 임계치 이상되면 분출
	private static void fire() {
		// 연쇄 분출 (압력 분출 제외)
		boolean flag = true;

		while (flag) {
			int count = 0;
			for (int i = 0; i < K; i++) {
				int[] mountain = mountains[i];
				if (v[i]) { // 분출했으면 패스
					continue;
				}

				if (pressure[i] + sum[mountain[0]][mountain[1]] >= mountain[2]) {
					count++;
					makeHeat(mountain);
					v[i] = true;
				}
			}
			if (count == 0) {
				flag = false;
			}
		}
	}

	private static void spread() {
		// 마그마 압력 분출
		for (int num = 0; num < K; num++) {
			int[] mountain = mountains[num];
			if (pressure[num] < mountain[2]) { // 압력 안넘으면
				continue;
			}
			makeHeat(mountain);
			v[num] = true;
		}
	}

	private static void makeHeat(int[] mountain) {
		int[][] heat = new int[N][N];

		for (int i = 0; i < 4; i++) {
			int x = mountain[1];
			int y = mountain[0];
			heat[y][x] = mountain[2];
			for (int j = 0; j < N; j++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[ny][nx] == 1) {
					break;
				}
				heat[ny][nx] = heat[y][x] / 2;
				x = nx;
				y = ny;
			}
		}

		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < N; j1++) {
				sum[i1][j1] += heat[i1][j1];
			}
		}

		// System.out.println("heat");
		// print(heat);
		// System.out.println("sum");
		// print(sum);
	}

	private static void move() {
		for (int i = 0; i < M; i++) {
			if (answer[i] != 0) {
				continue;
			}
			Point point = dfs(i);

			while (point.before != null) {
				if (point.before.before == null) {
					break;
				}
				point = point.before;
			}

			if (point.x == N - 1 && point.y == N - 1) {
				answer[i] = turn;
				turtles[i][0] = -1;
				turtles[i][1] = -1;
			} else {
				turtles[i][0] = point.y;
				turtles[i][1] = point.x;
			}
		}
	}

	private static Point dfs(int num) {
		Point ret = new Point(turtles[num][1], turtles[num][0], null);

		int[][] visited = new int[N][N];
		for (int[] v : visited) {
			Arrays.fill(v, -1);
		}
		Queue<Point> q = new ArrayDeque<>();
		q.add(ret);
		visited[turtles[num][0]][turtles[num][1]] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] != -1) {
					continue;
				}

				if (map[ny][nx] == 1 || map[ny][nx] == -1 || isTurtle(num, nx, ny)) {
					continue;
				}

				q.add(new Point(nx, ny, cur));
				visited[ny][nx] = visited[cur.y][cur.x] + 1;

				if (ny == N - 1 && nx == N - 1) {
					return new Point(nx, ny, cur);
				}
			}
		}

		return ret;
	}

	private static boolean isTurtle(int num, int nx, int ny) {
		for (int t = 0; t < M; t++) { // 다른 살아있는 거북
			if (answer[t] != 0) {
				continue;
			}
			if (t != num && turtles[t][0] == ny && turtles[t][1] == nx) {
				return true;
			}
		}
		return false;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Point {
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

// 안식처 n-1, n-1
// 시뮬레이션 최대 100턴

// 도착 시간 리스트
// 열기 배열 및 복사본
//
