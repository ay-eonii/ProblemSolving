package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p1700 {

	private static int k;
	private static int[] arr;
	private static int n;
	private static boolean[] visited;
	private static List<Integer> used;
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[k];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[k + 1];
		used = new ArrayList<>();
		count = 0;
		for (int i = 0; i < k; i++) {
			go(i);
		}

		System.out.println(count);
	}

	static void go(int idx) {
		int here = arr[idx];
		if (used.size() < n && !visited[here]) {
			used.add(here);
			visited[here] = true;
			return;
		}

		if (!visited[here]) {
			int lastIdx = 0, pos = 0;
			for (int u : used) {
				int remove = Integer.MAX_VALUE;
				for (int i = idx + 1; i < k; i++) {
					if (u == arr[i]) {
						remove = i;
						break;
					}
				}

				if (lastIdx < remove) {
					lastIdx = remove;
					pos = u;
				}
			}
			visited[pos] = false;
			visited[here] = true;
			used.remove((Integer)pos);
			used.add(here);
			count++;
		}
	}
}
