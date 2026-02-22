package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		Top[] tops = new Top[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tops[i] = new Top(x, y);
		}

		long R2 = (long)R * R;
		List<Integer>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				long dx = tops[i].x - tops[j].x;
				long dy = tops[i].y - tops[j].y;
				if (dx * dx + dy * dy <= R2) {
					adj[i].add(j);
					adj[j].add(i);
				}
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			long dx = tops[i].x - X;
			long dy = tops[i].y - Y;
			if (dx * dx + dy * dy <= R2) {
				tops[i].level = 0;
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : adj[cur]) {
				if (tops[next].level > tops[cur].level + 1) {
					tops[next].level = tops[cur].level + 1;
					q.add(next);
				}
			}
		}

		double answer = 0.0;
		for (int i = 0; i < N; i++) {
			if (tops[i].level == Integer.MAX_VALUE) {
				continue;
			}
			answer += D * Math.pow(0.5, tops[i].level);
		}

		System.out.println(answer);
	}

	static class Top {
		int x;
		int y;
		int level = Integer.MAX_VALUE;

		public Top(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
