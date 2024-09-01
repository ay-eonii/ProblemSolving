package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p20125 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] cookie = new char[n][n];

		boolean isHead = false;
		int[] heart = new int[2];
		for (int i = 0; i < n; i++) {
			char[] inputs = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				cookie[i][j] = inputs[j];
				if (!isHead && cookie[i][j] == '*') {
					heart[0] = i + 2;
					heart[1] = j + 1;
					isHead = true;
				}
			}
		}

		int[] body = new int[5];
		for (int i = heart[1] - 2; i >= 0; i--) {
			if (cookie[heart[0] - 1][i] == '*') {
				body[0]++;
			}
		}

		for (int i = heart[1]; i < n; i++) {
			if (cookie[heart[0] - 1][i] == '*') {
				body[1]++;
			}
		}

		for (int i = heart[0]; i < n; i++) {
			if (cookie[i][heart[1] - 1] == '*') {
				body[2]++;
			}
		}

		for (int i = heart[0] + body[2] - 1; i < n; i++) {
			if (cookie[i][heart[1] - 2] == '*') {
				body[3]++;
			}
		}

		for (int i = heart[0] + body[2] - 1; i < n; i++) {
			if (cookie[i][heart[1]] == '*') {
				body[4]++;
			}
		}

		System.out.println(heart[0] + " " + heart[1]);
		System.out.println(body[0] + " " + body[1] + " " + body[2] + " " + body[3] + " " + body[4]);
	}
}

// strategy
// 가장 위 : 머리
// 다음 줄 : 팔 , 심장, 팔
// 허리
// 다리 다리
