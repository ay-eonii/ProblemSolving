package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1753 {

	private static int[] dist;
	private static boolean[] visited;
	private static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int v = Integer.parseInt(inputs[0]);
		int e = Integer.parseInt(inputs[1]);
		int k = Integer.parseInt(br.readLine());

		visited = new boolean[v + 1];
		list = new ArrayList[v + 1];
		dist = new int[v + 1];
		Arrays.fill(dist, 100_000_000);

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			inputs = br.readLine().split(" ");
			int from = Integer.parseInt(inputs[0]);
			int to = Integer.parseInt(inputs[1]);
			int weight = Integer.parseInt(inputs[2]);
			list[from].add(new Node(to, weight));
		}

		dijkstra(k);

		for (int i = 1; i <= v; i++) {
			if (dist[i] == 100_000_000) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (!visited[now.to]) {
				visited[now.to] = true;
			}

			for (Node next : list[now.to]) {
				if (!visited[next.to] && dist[next.to] > now.weight + next.weight) {
					dist[next.to] = now.weight + next.weight;
					queue.add(new Node(next.to, dist[next.to]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}

// strategy
// 다익스트라
