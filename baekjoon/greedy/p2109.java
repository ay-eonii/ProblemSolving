package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2109 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			pairs[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		Arrays.sort(pairs, (o1, o2) -> {
			if (o2.cost == o1.cost) {
				return o1.due - o2.due;
			}
			return o2.cost - o1.cost;
		});

		int money = 0;
		boolean[] visited = new boolean[10001];
		for (Pair p : pairs) {
			int date = p.due;
			while (date > 0 && visited[date]) {
				date--;
			}

			if (date > 0) {
				money += p.cost;
				visited[date] = true;
			}
		}

		System.out.println(money);
	}

	static class Pair {
		int cost;
		int due;

		public Pair(int cost, int due) {
			this.cost = cost;
			this.due = due;
		}
	}
}
