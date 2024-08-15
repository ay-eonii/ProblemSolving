package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p20055 {

	private static LinkedList<Belt> belt;
	private static int n;
	private static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		k = Integer.parseInt(inputs[1]);
		int size = n * 2;
		belt = new LinkedList<>();

		inputs = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			belt.add(i, new Belt(Integer.parseInt(inputs[i])));
		}

		int turn = 0;
		while (0 < k) { // 4단계
			turn++;
			turn(); // 1단계
			move(); // 2단계
			put(); // 3단계
		}

		System.out.println(turn);
	}

	private static void turn() {
		belt.add(0, belt.removeLast()); // 꺼낸 거 처음으로
		downRobot();
	}

	private static void move() {
		for (int i = n - 1; i > 0; i--) {
			if (!belt.get(i).hasRobot || belt.get(i + 1).hasRobot || belt.get(i + 1).durability <= 0) {
				continue;
			}
			belt.get(i + 1).putRobot();
			belt.get(i).hasRobot = false;
		}
		downRobot();
	}

	private static void put() {
		if (belt.get(0).durability > 0) {
			belt.get(0).putRobot();
		}
	}

	private static void downRobot() {
		belt.get(n - 1).hasRobot = false;
	}

	static class Belt {
		int durability;
		boolean hasRobot;

		public Belt(int durability) {
			this.durability = durability;
			this.hasRobot = false;
		}

		public void putRobot() {
			hasRobot = true;
			durability--;
			if (durability <= 0) {
				k--;
			}
		}
	}
}
