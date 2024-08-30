package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14499 {
	private static final int[][] directions = {
		{0, 0},
		{0, 1},  // 동
		{0, -1}, // 서
		{-1, 0}, // 북
		{1, 0}   // 남
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]); // 세로
		int M = Integer.parseInt(inputs[1]); // 가로
		int y = Integer.parseInt(inputs[2]); // 주사위 위치 y
		int x = Integer.parseInt(inputs[3]); // 주사위 위치 x
		int K = Integer.parseInt(inputs[4]); // 명령 개수

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Dice dice = new Dice();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int direction = Integer.parseInt(st.nextToken());
			int ny = y + directions[direction][0];
			int nx = x + directions[direction][1];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
				continue;
			}

			x = nx;
			y = ny;
			dice.roll(direction);

			if (map[y][x] == 0) {
				map[y][x] = dice.getBottomNumber();
			} else {
				dice.copyBottom(map[y][x]);
				map[y][x] = 0;
			}

			System.out.println(dice.getTopNumber());
		}
	}

	static class Dice {
		/**
		 *   2
		 * 4 1 3
		 *   5
		 *   6
		 */

		int[] dice = new int[] {0, 0, 0, 0, 0, 0, 0};

		public void copyBottom(int bottomNumber) {
			dice[6] = bottomNumber;
		}

		void roll(int direction) {
			int tmp = dice[3];
			switch (direction) {
				case 1:
					dice[3] = dice[4];
					dice[4] = dice[6];
					dice[6] = dice[2];
					dice[2] = tmp;
					break;
				case 2:
					dice[3] = dice[2];
					dice[2] = dice[6];
					dice[6] = dice[4];
					dice[4] = tmp;
					break;
				case 3:
					dice[3] = dice[5];
					dice[5] = dice[6];
					dice[6] = dice[1];
					dice[1] = tmp;
					break;
				case 4:
					dice[3] = dice[1];
					dice[1] = dice[6];
					dice[6] = dice[5];
					dice[5] = tmp;
					break;
			}
		}

		public int getBottomNumber() {
			return dice[6];
		}

		public int getTopNumber() {
			return dice[3];
		}
	}
}

// strategy
// r: 북쪽으로 떨어진 칸의 개수 (위로부터)
// c: 서쪽으로 떨어진 칸의 개수 (왼쪽으로부터)
//
// -- 입력 --
// 서 동
// 0 2 북
// 3 4
// 5 6
// 7 8 남
// * 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
