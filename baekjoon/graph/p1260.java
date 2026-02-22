package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1260 {

	private static boolean[] visited;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		StringBuilder sb = new StringBuilder();
		visited = new boolean[N + 1];
		List<Integer> answer = dfs(V, new ArrayList<>());
		for (int a : answer) {
			sb.append(a + " ");
		}
		sb.append("\n");

		visited = new boolean[N + 1];
		answer = bfs(V);
		for (int a : answer) {
			sb.append(a + " ");
		}

		System.out.println(sb);
	}

	static List<Integer> dfs(int here, List<Integer> answer) {
		answer.add(here);
		visited[here] = true;

		if (graph[here].isEmpty()) {
			return answer;
		}

		for (int there : graph[here]) {
			if (visited[there]) {
				continue;
			}

			answer = dfs(there, answer);
		}

		return answer;
	}

	static List<Integer> bfs(int here) {
		List<Integer> answer = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(here);
		visited[here] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			answer.add(cur);

			for (int there : graph[cur]) {
				if (visited[there]) {
					continue;
				}
				q.add(there);
				visited[there] = true;
			}
		}

		return answer;
	}
}
