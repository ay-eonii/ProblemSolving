package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p9934 {

	private static ArrayList<Integer>[] ret;
	private static int[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = (int)Math.pow(2, k) - 1;
		node = new int[len];
		for (int i = 0; i < Math.pow(2, k) - 1; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}

		ret = new ArrayList[k];
		for (int i = 0; i < k; i++) {
			ret[i] = new ArrayList<>();
		}
		go(0, len - 1, 0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			for (int num : ret[i]) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	static void go(int s, int e, int level) {
		if (s > e) {
			return;
		}

		if (s == e) {
			ret[level].add(node[s]);
			return;
		}

		int mid = (s + e) / 2;
		ret[level].add(node[mid]);
		go(s, mid - 1, level + 1);
		go(mid + 1, e, level + 1);
	}
}
