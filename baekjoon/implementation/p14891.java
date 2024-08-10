package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p14891 {

	private static final int[] point12 = {0, 0, 0, 0}; // 12시 방향
	private static String[][] cogwheels;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cogwheels = new String[4][8];
		for (int i = 0; i < 4; i++) {
			cogwheels[i] = br.readLine().split("");
		}

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			String[] command = br.readLine().split(" ");
			int wheelNumber = Integer.parseInt(command[0]) - 1;
			int direction = Integer.parseInt(command[1]);

			bfs(new Wheel(wheelNumber, direction));
		}

		int answer = 0;
		for (int i = 0; i < 4; i++) {
			answer += (cogwheels[i][point12[i]].equals("0")) ? 0 : (int)Math.pow(2, i);
		}

		System.out.println(answer);
	}

	private static void bfs(Wheel wheel) {
		Queue<Wheel> queue = new LinkedList<>();
		boolean[] visited = new boolean[4];
		int[] turn = new int[4];
		queue.add(wheel);

		while (!queue.isEmpty()) {
			Wheel current = queue.poll();
			turn[current.order] = current.direction;
			visited[current.order] = true;
			if (current.isNotFirst() && !visited[current.order - 1]) { // 왼쪽 탐색
				if (!cogwheels[current.order][((point12[current.order]) + 6) % 8].equals(
					cogwheels[current.order - 1][((point12[current.order - 1]) + 2) % 8])) { // 왼쪽과 다른 극
					Wheel leftWheel = current.getLeftWheel();
					queue.add(leftWheel);
				}
			}
			if (current.isNotLast() && !visited[current.order + 1]) { // 오른쪽 탐색
				if (!cogwheels[current.order][((point12[current.order]) + 2) % 8].equals(
					cogwheels[current.order + 1][((point12[current.order + 1]) + 6) % 8])) { // 오른쪽과 다른 극
					Wheel rightWheel = current.getRightWheel();
					queue.add(rightWheel);
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			if (turn[i] == 1) { // 시계방향 0 -> 7
				point12[i] = (point12[i] + 7) % 8;
			} else if (turn[i] == -1) { // 반시계방향 0 -> 1
				point12[i] = (point12[i] + 1) % 8;
			}
		}
	}

	private static class Wheel {
		int order;
		int direction;

		public Wheel(int order, int direction) {
			this.order = order;
			this.direction = direction;
		}

		public boolean isNotFirst() {
			return order != 0;
		}

		public boolean isNotLast() {
			return order != 3;
		}

		public Wheel getLeftWheel() {
			return new Wheel(order - 1, -direction);
		}

		public Wheel getRightWheel() {
			return new Wheel(order + 1, -direction);
		}
	}
}

// strategy
// 구현
// bfs
