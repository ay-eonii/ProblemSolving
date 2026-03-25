package baekjoon.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1647 {

	private static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		p = new int[n + 1];
		Arrays.fill(p, -1);

		Node[] graph = new Node[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[i] = new Node(a, b, c);
		}

		Arrays.sort(graph, (o1, o2) -> o1.c - o2.c);

		long answer = 0;
		long max = 0;
		for (Node node : graph) {
			if (find(node.a) != find(node.b)) {
				union(node.a, node.b);
				answer += node.c;
				max = Math.max(max, node.c);
			}
		}

		System.out.println(answer - max);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			p[y] = x;
		}
	}

	static int find(int x) {
		if (p[x] == -1) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	static class Node {
		int a;
		int b;
		int c;

		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
