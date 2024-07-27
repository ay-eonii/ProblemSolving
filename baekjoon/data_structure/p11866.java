package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!queue.isEmpty()) {
			int turn = 1;
			while (!queue.isEmpty() && turn < k) {
				queue.add(queue.poll());
				turn++;
			}
			Integer poll = queue.poll();
			sb.append(poll);

			if (!queue.isEmpty()) {
				sb.append(", ");
			}
		}
		sb.append(">");

		System.out.print(sb);
	}
}
