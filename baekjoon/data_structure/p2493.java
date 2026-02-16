package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] t = new int[N];
		for (int i = 0; i < N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Building> stack = new Stack<>();
		int[] answer = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.push(new Building(i, t[i]));
				continue;
			}

			while (!stack.isEmpty() && stack.peek().height <= t[i]) {
				Building building = stack.pop();
				answer[building.location] = i + 1;
			}
			stack.push(new Building(i, t[i]));
		}

		StringBuilder sb = new StringBuilder();
		for (int a : answer) {
			sb.append(a + " ");
		}

		System.out.println(sb);
	}

	static class Building {
		int location;
		int height;

		public Building(int location, int height) {
			this.location = location;
			this.height = height;
		}
	}
}

// 짝맞추기 -> 스택
