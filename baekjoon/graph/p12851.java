package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p12851 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		int[] answer = bfs(N, K);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	static int[] bfs(int n, int k) {
		int len = 200_004;
		int[] visited = new int[len];
		int[] count = new int[len];
		count[n] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(n);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : new int[] {now - 1, now + 1, now * 2}) {
				if (next < 0 || next >= len) {
					continue;
				}

				if (visited[next] == visited[now] + 1) {
					count[next] += count[now];
					continue;
				} else if (visited[next] != 0) {
					continue;
				}

				count[next] += count[now];
				visited[next] = visited[now] + 1;
				q.add(next);
			}
		}

		return new int[] {visited[k], count[k]};
	}
}
