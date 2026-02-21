package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class p2583 {

	private static final int[] dx = {0, 0, -1, 1}; //상하좌우
	private static final int[] dy = {-1, 1, 0, 0}; //상하좌우
	private static int[][] arr;
	private static boolean[][] visited;
	private static int M;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new int[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());

			for (int x = lx; x < rx; x++) {
				for (int y = M - ry; y < M - ly; y++) {
					arr[y][x] = -1;
				}
			}
		}

		visited = new boolean[M][N];
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != -1 && !visited[i][j]) {
					answer.add(dfs(j, i));
				}
			}
		}

		System.out.println(answer.size());

		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		for (int a : answer) {
			sb.append(a + " ");
		}

		System.out.println(sb);
	}

	static int dfs(int x, int y) {
		visited[y][x] = true;
		int ret = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[ny][nx]) {
				continue;
			}

			if (arr[ny][nx] == -1) {
				continue;
			}

			ret += dfs(nx, ny);
		}

		return ret;
	}
}
