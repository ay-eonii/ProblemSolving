package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17127 {

	private static boolean[] visited;
	private static int[] trees;
	private static int n;
	private static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		trees = new int[n];
		visited = new boolean[n];

		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(inputs[i]);
		}

		recur(0, 0);
		System.out.print(max);
	}

	private static void recur(int start, int count) {
		if (count == 4) {
			int sum = 0;
			int temp = 1;
			for (int i = 0; i < n; i++) {
				temp *= trees[i];
				if (visited[i]) {
					sum += temp;
					temp = 1;
				}
			}
			max = Math.max(max, sum);
			return;
		}

		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				recur(start + 1, count + 1);
				visited[i] = false;
				recur(start + 1, count);
			}
		}
	}
}

// strategy
// 완전 탐색
// N <= 10
// visited[i] = true 4개
