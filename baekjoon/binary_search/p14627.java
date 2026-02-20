package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14627 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int S = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);

		long[] arr = new long[S];
		long max = 0;
		for (int i = 0; i < S; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long min = max / C;
		long answer = Long.MAX_VALUE;
		while (min <= max) {
			long mid = (min + max) / 2;
			long left = check(mid, arr, C);
			if (left == -1) {
				max = mid - 1;
			} else {
				answer = Math.min(answer, left);
				min = mid + 1;
			}
		}

		System.out.println(answer);
	}

	static long check(long mid, long[] arr, int c) {
		long count = c;
		long left = 0;
		for (long a : arr) {
			if (a / mid <= count) {
				left += a % mid;
				count -= a / mid;
			} else {
				left += a - (mid * count);
				count = 0;
			}
		}

		if (count > 0) {
			return -1;
		} else {
			return left;
		}
	}
}
