package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2607 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] target = br.readLine().toCharArray();

		int[] targetCount = new int[26];
		for (
			char c : target) {
			targetCount[c - 'A']++;
		}

		int answer = 0;
		for (
			int i = 0; i < n - 1; i++) {
			int[] tempCount = new int[26];
			char[] split = br.readLine().toCharArray();
			for (char c : split) {
				tempCount[c - 'A']++;
			}

			int diff = 0;
			boolean isDifferent = false;
			for (int j = 0; j < 26; j++) {
				if (targetCount[j] != tempCount[j]) {
					int abs = Math.abs(targetCount[j] - tempCount[j]);
					if (abs >= 2 || Math.abs(target.length - split.length) > 1) {
						isDifferent = true;
						break;
					}
					diff += abs;
				}
			}

			if (diff <= 2 && !isDifferent) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
