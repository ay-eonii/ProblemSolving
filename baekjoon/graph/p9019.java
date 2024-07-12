package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;

public class p9019 {
	private static final Function<Integer, Integer> d = (n) -> (n * 2) % 10000;
	private static final Function<Integer, Integer> s = (n) -> n == 0 ? 9999 : n - 1;
	private static final Function<Integer, Integer> l = (n) -> (n % 1000) * 10 + (n / 1000);
	private static final Function<Integer, Integer> r = (n) -> (n % 10) * 1000 + (n / 10);
	private static final Map<String, Function<Integer, Integer>> commands = Map.of(
		"D", d,
		"S", s,
		"L", l,
		"R", r
	);
	private static int after;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] inputs = br.readLine().split(" ");
			int before = Integer.parseInt(inputs[0]);
			after = Integer.parseInt(inputs[1]);
			bfs(before);
		}
	}

	public static void bfs(int before) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		String[] answers = new String[10000];
		Arrays.fill(answers, "");
		queue.add(before);
		visited[before] = true;

		while (!queue.isEmpty() && !visited[after]) {
			Integer current = queue.poll();
			for (String command : commands.keySet()) {
				Integer result = commands.get(command).apply(current);
				if (!visited[result]) {
					queue.add(result);
					visited[result] = true;
					answers[result] = answers[current] + command;
				}
			}
		}

		System.out.println(answers[after]);
	}
}

// strategy
// 0 이상 10,000 미만의 십진수 저장

