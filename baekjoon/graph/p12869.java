package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p12869 {

	static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int[] scv = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens()) {
			scv[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		System.out.println(bfs(scv));
	}

	static int bfs(int[] scv) {
		Queue<int[]> q = new LinkedList<>();
		int[][][] visited = new int[61][61][61];
		q.add(scv);
		int ret = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			int a = current[0];
			int b = current[1];
			int c = current[2];
			for (int i = 0; i < attack.length; i++) {
				int na = Math.max(a - attack[i][0], 0);
				int nb = Math.max(b - attack[i][1], 0);
				int nc = Math.max(c - attack[i][2], 0);
				if (visited[na][nb][nc] != 0) {
					continue;
				}

				if (na == 0 && nb == 0 && nc == 0) {
					ret = Math.min(ret, visited[a][b][c] + 1);
					continue;
				}

				visited[na][nb][nc] = visited[a][b][c] + 1;
				q.add(new int[] {na, nb, nc});
			}
		}

		return ret;
	}
}
