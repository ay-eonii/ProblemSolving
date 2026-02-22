package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p1325 {

	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			graph[B].add(A);
		}

		int max = 0;
		int[] dp = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			dp[i] = bfs(i);
			max = Math.max(dp[i], max);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (dp[i] == max) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}

	static int bfs(int here) {
		Queue<Integer> q = new LinkedList<>();
		q.add(here);
		visited[here] = true;
		int ret = 1;

		while (!q.isEmpty()) {
			int current = q.poll();
			for (int next : graph[current]) {
				if (visited[next]) {
					continue;
				}

				ret++;
				q.add(next);
				visited[next] = true;
			}
		}

		return ret;
	}
}
