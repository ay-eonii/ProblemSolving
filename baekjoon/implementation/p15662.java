package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p15662 {

	private static List<Character>[] chains;
	private static int t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		chains = new ArrayList[t];
		for (int i = 0; i < t; i++) {
			char[] input = br.readLine().toCharArray();
			chains[i] = new ArrayList<>();
			for (int j = 0; j < 8; j++) {
				chains[i].add(input[j]);
			}
		}

		int k = Integer.parseInt(br.readLine());
		int[][] order = new int[k][2];
		for (int i = 0; i < k; i++) {
			String[] split = br.readLine().split(" ");
			order[i][0] = Integer.parseInt(split[0]) - 1;
			order[i][1] = Integer.parseInt(split[1]);
		}

		for (int i = 0; i < k; i++) {
			int[] visited = spin(order[i][0], order[i][1]);
			for (int j = 0; j < t; j++) {
				if (visited[j] == 1 || visited[j] == -1) {
					change(chains[j], visited[j]);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < t; i++) {
			if (chains[i].get(0) == '1') {
				count++;
			}
		}

		System.out.println(count);
	}

	static int[] spin(int c, int d) {
		int[] visited = new int[t];
		Arrays.fill(visited, -2);
		Queue<Integer> q = new LinkedList<>();
		q.add(c);
		visited[c] = d;

		while (!q.isEmpty()) {
			int here = q.poll();
			for (int i : new int[] {1, -1}) {
				int next = here + i;
				if (next < 0 || next >= t || visited[next] != -2) {
					continue;
				}

				visited[next] = check(here, next, visited[here]);
				if (visited[next] != 0) {
					q.add(next);
				}
			}
		}

		return visited;
	}

	static int check(int here, int next, int d) {
		if (here > next) {
			if (chains[here].get(6) != chains[next].get(2)) {
				return -d;
			}
			return 0;
		}
		if (chains[here].get(2) != chains[next].get(6)) {
			return -d;
		}
		return 0;
	}

	static void change(List<Character> chain, int d) {
		if (d == 1) {
			chain.add(0, chain.remove(7));
		} else {
			chain.add(chain.remove(0));
		}
	}
}
