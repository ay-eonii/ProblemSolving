package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1561 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long N = Long.parseLong(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long min = 0;
		long max = N * 30;
		long ret = Long.MAX_VALUE;
		while (min <= max) {
			long mid = (min + max) / 2;
			if (check(mid, arr, N)) {
				max = mid - 1;
				ret = Math.min(ret, mid);
			} else {
				min = mid + 1;
			}
		}

		long sum = 0;
		for (int a : arr) {
			sum += (ret / a) + 1;
		}

		for (int i = M - 1; i >= 0; i--) {
			if (ret % arr[i] == 0) {
				if (sum == N) {
					System.out.println(i + 1);
					break;
				} else {
					sum--;
				}
			}
		}
	}

	static boolean check(long mid, int[] arr, long N) {
		long sum = 0;
		for (int a : arr) {
			sum += (mid / a) + 1;
		}

		return N <= sum;
	}
}

// 이분탐색
// min, max, mid = 놀이기구 타는 타이밍
