package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1189 {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};
	private static boolean[][] visited;
	private static int k;
	private static int answer;
	private static int r;
	private static int c;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			if (r == 1 && c == 1 && map[0][0] == 'T') {
				System.out.println(0);
				return;
			}
		}

		visited = new boolean[r][c];
		answer = 0;
		visited[r - 1][0] = true;
		go(1, 0, r - 1);

		System.out.println(answer);
	}

	static void go(int count, int x, int y) {
		if (count >= k) {
			if (count == k && y == 0 && x == c - 1) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= c || ny < 0 || ny >= r || visited[ny][nx]) {
				continue;
			}

			if (map[ny][nx] == 'T') {
				continue;
			}

			visited[ny][nx] = true;
			go(count + 1, nx, ny);
			visited[ny][nx] = false;
		}
	}
}
