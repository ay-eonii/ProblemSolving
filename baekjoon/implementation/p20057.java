package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20057 {

	private final static int[] dx = {-1, 1};
	private final static int[] dy = {1, -1};
	private static int[][] rate = {
		{0, 0, 2, 0, 0},
		{0, 10, 7, 1, 0},
		{5, 100, 0, 0, 0},
		{0, 10, 7, 1, 0},
		{0, 0, 2, 0, 0,}
	};
	private static int[][] map;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		int total = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}

		int[] current = new int[] {n / 2, n / 2};
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 1; k <= i; k++) {
					current = go(i, j, current);
					if (current[0] < 0 || current[1] < 0 || current[0] >= n || current[1] >= n) {
						break;
					}
					moveSand(current);
				}
				rate = turn();
			}
		}

		for (int k = 1; k <= n - 1; k++) {
			current = new int[] {current[0] - 1, current[1]}; // 왼쪽
			if (current[0] < 0 || current[1] < 0 || current[0] >= n || current[1] >= n) {
				break;
			}
			moveSand(current);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				total -= map[i][j];
			}

		}

		System.out.println(total);
	}

	/**
	 * -1,0 -> 0,1 -> 2,0 -> 0,-2-> -3,0-> 0,3
	 */
	static int[] go(int i, int j, int[] current) {
		if (j == 0) {
			// x
			if (i % 2 == 1) {
				return new int[] {current[0] + dx[0], current[1]};
			}
			return new int[] {current[0] + dx[1], current[1]};
		} else {
			// y
			if (i % 2 == 1) {
				return new int[] {current[0], current[1] + dy[0]};
			}
			return new int[] {current[0], current[1] + dy[1]};
		}
	}

	static void moveSand(int[] current) {
		int sand = map[current[1]][current[0]];
		map[current[1]][current[0]] = 0;
		int alpha = sand;
		int[] alphaL = new int[2];
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				int nx = current[0] + j;
				int ny = current[1] + i;
				int nSand = sand * rate[i + 2][j + 2] / 100;

				if (rate[i + 2][j + 2] != 100) {
					alpha -= nSand;
				} else {
					alphaL[0] = nx;
					alphaL[1] = ny;
					continue;
				}

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}

				map[ny][nx] += nSand;
			}
		}

		if (alphaL[0] >= 0 && alphaL[0] < n && alphaL[1] >= 0 && alphaL[1] < n) {
			map[alphaL[1]][alphaL[0]] += alpha;
		}
	}

	static int[][] turn() {
		int[][] ret = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ret[5 - j - 1][i] = rate[i][j];
			}
		}

		return ret;
	}
}

// 회전

// 0 0 0 0 0
// 1 0 0 0 0
// 8 . 0 0 0
// 1 0 0 0 0
// 0 0 0 0 0
