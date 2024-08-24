package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2885 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		int n = 0;
		while (Math.pow(2, n) < k) {
			n++;
		}

		int size = (int)Math.pow(2, n);
		if (size == k) {
			System.out.println(size + " " + 0);
			return;
		}

		int min = 1;
		int max = n;
		int answer = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			int separate = (int)Math.pow(2, mid);
			int resultCount = size / separate;
			if (k % resultCount != 0) {
				min++;
			} else {
				answer = mid;
				max--;
			}
		}

		System.out.println(size + " " + answer);
	}
}

// strategy
// 2^1, 2^2, 2^3 ... 2^n
// while (2^n >= k)
// 8 / 2 = 4
// 8 / 4 = 2
// size / separate = resultCount
// 이분탐색 => 대상: 2^a 에서 a
// min = 1
// max = n
