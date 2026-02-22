package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1068 {

	private static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = -1;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			arr[i] = parent;
			if (parent == -1) {
				root = i;
			} else {
				tree[parent].add(i);
			}
		}

		int del = Integer.parseInt(br.readLine());
		if (arr[del] == -1) {
			System.out.println(0);
			return;
		}

		tree[arr[del]].remove((Integer)del);

		int answer = dfs(root, del);
		System.out.println(answer);
	}

	static int dfs(int parent, int del) {
		int ret = 0;
		if (tree[parent].isEmpty()) {
			return 1;
		}

		for (int child : tree[parent]) {
			if (child == del) {
				continue;
			}

			ret += dfs(child, del);
		}

		return ret;
	}
}
