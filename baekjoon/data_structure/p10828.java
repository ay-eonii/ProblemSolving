package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();

			switch (input) {
				case "pop":
					if (stack.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(stack.pop()).append("\n");
					}
					continue;

				case "size":
					sb.append(stack.size()).append("\n");
					continue;

				case "empty":
					if (stack.isEmpty()) {
						sb.append("1").append("\n");
					} else {
						sb.append("0").append("\n");
					}
					continue;

				case "top":
					if (stack.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
					continue;

				default:
					String[] inputs = input.split(" ");
					stack.push(Integer.parseInt(inputs[1]));
			}
		}
		System.out.print(sb);
	}
}
