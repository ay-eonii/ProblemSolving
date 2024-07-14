package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p11725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> tree = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			String[] inputs = br.readLine().split(" ");
			int n1 = Integer.parseInt(inputs[0]) - 1;
			int n2 = Integer.parseInt(inputs[1]) - 1;
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}

		boolean[] visited = new boolean[n];
		int[] parentNode = new int[n];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int node : tree.get(v))
				if (!visited[node]) {
					visited[node] = true;
					queue.add(node);
					parentNode[node] = v;
				}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(parentNode[i] + 1);
		}
	}
}
