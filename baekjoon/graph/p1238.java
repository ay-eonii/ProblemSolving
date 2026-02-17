package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1238 {

	private static int N;
	private static int M;
	private static int X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;

		List<Town>[] map = new ArrayList[N];
		List<Town>[] reverseMap = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
			reverseMap[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			map[from].add(new Town(to, t));
			reverseMap[to].add(new Town(from, t));
		}

		int[] back = dijkstra(map);
		int[] go = dijkstra(reverseMap);

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, go[i] + back[i]);
		}

		System.out.println(max);
	}

	static int[] dijkstra(List<Town>[] map) {
		boolean[] visited = new boolean[N];
		int[] result = new int[N];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[X] = 0;

		PriorityQueue<Town> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		q.add(new Town(X, 0));

		while (!q.isEmpty()) {
			Town current = q.poll();

			if (visited[current.to]) {
				continue;
			}

			visited[current.to] = true;
			for (Town t : map[current.to]) {
				if (current.cost + t.cost < result[t.to]) {
					result[t.to] = current.cost + t.cost;
					q.add(new Town(t.to, result[t.to]));
				}
			}
		}

		return result;
	}

	static class Town {
		int to;
		int cost;

		public Town(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}

// 최단거리 중 최대

// . 4 2 7
// 1 . 5 x
// 2 x . 4
// x 3 x .

