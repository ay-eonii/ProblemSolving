package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class p9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();

		int[] flag = new int[input.length];
		Arrays.fill(flag, -1);
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			stack.push(input[i]);

			if (stack.size() >= bomb.length) {
				boolean ok = true;
				for (int j = 0; j < bomb.length; j++) {
					if (stack.get(stack.size() - bomb.length + j) != bomb[j]) {
						ok = false;
						break;
					}
				}

				if (ok) {
					for (int j = 0; j < bomb.length; j++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
			return;
		}

		char[] answer = new char[stack.size()];
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			int idx = stack.size();
			answer[idx - 1] = stack.pop();
		}

		for (char c : answer) {
			sb.append(c);
		}

		System.out.println(sb);
	}

}
