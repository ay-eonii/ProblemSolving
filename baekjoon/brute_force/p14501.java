package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p14501 {

	private static int n;
	private static int[] p;
	private static int[] t;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new int[n + 1];
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			String[] inputs = br.readLine().split(" ");
			t[i] = Integer.parseInt(inputs[0]);
			p[i] = Integer.parseInt(inputs[1]);
		}

		for (int i = 1; i <= n; i++) {
			bfs(i);
		}

		System.out.print(answer);
	}

	private static void bfs(int i) {
		Queue<Counsel> queue = new LinkedList<>();
		if (i + t[i] - 1 <= n) {
			queue.add(new Counsel(i, p[i]));
		}

		while (!queue.isEmpty()) {
			Counsel current = queue.poll();
			int nextStartDay = current.day + t[current.day];

			for (int j = nextStartDay; j <= n; j++) {
				if (j + t[j] - 1 <= n) {
					queue.add(new Counsel(j, current.pay + p[j]));
				}
			}
			answer = Math.max(answer, current.pay);
		}
	}

	static class Counsel {
		int day;
		int pay;

		public Counsel(int day, int pay) {
			this.day = day;
			this.pay = pay;
		}
	}
}

// strategy
// 브루트포스
