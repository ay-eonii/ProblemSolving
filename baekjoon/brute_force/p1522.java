package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1522 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int total = 0; // a가 total 길이만큼 연속해야함
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'a') {
				total++;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length(); i++) {
			int bCount = 0;

			for (int j = i; j < total + i; j++) {
				if (input.charAt(j % input.length()) == 'b') {
					bCount++;
				}
			}
			min = Math.min(bCount, min);
		}
		System.out.println(min);
	}
}

// strategy
// 완전탐색
