package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class p12100 {

	private static int n;
	private static int[][] arr;
	private static int ret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		ret = 0;
		go(0, arr);
		System.out.println(ret);
	}

	static void go(int count, int[][] map) {
		if (count == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ret = Math.max(ret, map[i][j]);
				}
			}
			return;
		}

		int[][] rotate = map;
		for (int k = 0; k < 4; k++) {
			int[][] next = new int[n][n];
			for (int i = 0; i < n; i++) { // 열
				Deque<Integer> deque = new ArrayDeque<>();
				boolean pass = false;
				for (int j = 0; j < n; j++) { // 행
					if (rotate[j][i] == 0) {
						continue;
					}
					if (!deque.isEmpty()) {
						int last = deque.peekLast();
						if (pass || last != rotate[j][i]) {
							deque.add(rotate[j][i]);
							pass = false;
						} else if (last == rotate[j][i]) {
							deque.pollLast();
							deque.add(rotate[j][i] * 2);
							pass = true;
						}
					} else {
						deque.add(rotate[j][i]);
					}
				}
				int idx = 0;
				while (!deque.isEmpty()) {
					next[idx][i] = deque.pollFirst();
					idx++;
				}
			}
			go(count + 1, next);

			int[][] temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j] = rotate[n - j - 1][i];
				}
			}

			rotate = temp;
		}
	}
}
