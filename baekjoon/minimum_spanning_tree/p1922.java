package baekjoon.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1922 {

	private static Node[] nodes;
	private static ArrayList<Integer>[] link;
	private static int n;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		nodes = new Node[m];
		parent = new int[n + 1];
		Arrays.fill(parent, -1);

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(a, b, c);
		}

		Arrays.sort(nodes, (o1, o2) -> o1.c - o2.c);

		int answer = 0;
		for (int i = 0; i < m; i++) {
			Node current = nodes[i];

			// 연결 확인
			if (find(current.a) != find(current.b)) {
				answer += current.c;
				union(current.a, current.b);
			}
		}

		System.out.println(answer);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		// 부모 다르면 연결
		if (x != y) {
			parent[y] = x;
		}
	}

	static int find(int x) {
		if (parent[x] == -1) {
			// x가 루트인 경우
			return x;
		}

		return parent[x] = find(parent[x]); // 경로 압축
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
