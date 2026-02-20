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
		long sum = 0;
		for (int i = 0; i < S; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}

		long min = max / C;
		long ret = 0;
		while (min <= max) {
			long mid = (min + max) / 2;
			if (check(mid, arr, C)) {
				min = mid + 1;
				ret = Math.max(ret, mid);
			} else {
				max = mid - 1;
			}
		}

		System.out.println(sum - (ret * C));
	}

	static boolean check(long mid, long[] arr, int c) {
		long count = 0;
		for (long a : arr) {
			count += a / mid;
		}

		return count >= c;
	}
}
