package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int last = -1;
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			switch (command) {
				case "pop":
					if (queue.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(queue.poll()).append("\n");
					}
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(queue.peek()).append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(last).append("\n");
					}
					break;
				case "empty":
					if (queue.isEmpty()) {
						sb.append("1").append("\n");
					} else {
						sb.append("0").append("\n");
					}
					break;
				default:
					int push = Integer.parseInt(command.split(" ")[1]);
					queue.add(push);
					last = push;
			}
		}
		System.out.print(sb);
	}
}
