package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p13913 {

	public static final int LEN = 200_004;
	private static int[] trace;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		if (N == K) {
			System.out.println(0);
			System.out.println(K);
			return;
		}

		trace = new int[LEN];
		int answer = bfs(N, K);
		System.out.println(answer);

		Stack<Integer> stack = new Stack<>();
		stack.add(K);
		int p = K;
		while (p != N) {
			stack.add(trace[p]);
			p = trace[p];
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}

	static int bfs(int n, int k) {
		int[] visited = new int[LEN];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : new int[] {now - 1, now + 1, now * 2}) {
				if (next < 0 || next >= LEN || visited[next] != 0) {
					continue;
				}

				visited[next] = visited[now] + 1;
				trace[next] = now;
				q.add(next);
			}
		}

		return visited[k];
	}
}
