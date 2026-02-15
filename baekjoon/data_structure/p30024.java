package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p30024 {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);

		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		PriorityQueue<Corn> maxHeap = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
		for (int i = 0; i < N; i++) { // 행 -> y
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {  // 열 -> x
				int v = Integer.parseInt(st.nextToken());
				if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
					maxHeap.add(new Corn(j, i, v));
					visited[i][j] = true;
				}
				arr[i][j] = v;
			}
		}

		int K = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			if (maxHeap.isEmpty()) {
				break;
			}

			Corn corn = maxHeap.poll();
			sb.append((corn.y + 1) + " " + (corn.x + 1) + "\n");

			for (int i = 0; i < 4; i++) {
				int nx = corn.x + dx[i];
				int ny = corn.y + dy[i];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) {
					continue;
				}

				visited[ny][nx] = true;
				maxHeap.add(new Corn(nx, ny, arr[ny][nx]));
			}
		}

		System.out.print(sb);
	}

	static class Corn {
		int x; // 열
		int y; // 행
		int v;

		public Corn(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
}

// 1000*1000 -> 1,000,000 -> O(N)
// visited
// maxHeap
//
