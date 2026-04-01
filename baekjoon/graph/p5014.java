package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5014 {

	private static int f;
	private static int s;
	private static int u;
	private static int d;
	private static int g;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		if (s == g) {
			System.out.println(0);
			return;
		}

		int answer = bfs();
		System.out.println(answer == -1 ? "use the stairs" : answer);
	}

	static int bfs() {
		int[] visited = new int[f + 1];
		Arrays.fill(visited, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		visited[s] = 0;

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			int next = current + u;
			if (next <= f && visited[next] == -1) {
				visited[next] = visited[current] + 1;
				queue.add(next);
			}

			next = current - d;
			if (next > 0 && visited[next] == -1) {
				visited[next] = visited[current] + 1;
				queue.add(next);
			}

			if (next == g) {
				break;
			}
		}

		return visited[g];
	}
}
