package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10709 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int H = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (arr[j] == '.') {
					map[i][j] = -1;
				}
			}
		}

		for (int i = 1; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][i - 1] != -1 && map[j][i] != 0) {
					map[j][i] = map[j][i - 1] + 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
