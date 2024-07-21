package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		StringTokenizer st = new StringTokenizer(br.readLine());

		long total = 0;
		int[] lectures = new int[n];
		long min = 0;
		for (int i = 0; i < n; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			total += lectures[i];
			min = Math.max(min, lectures[i]);
		}

		long max = total;
		while (min <= max) {
			long mid = (min + max) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (sum + lectures[i] > mid) {
					count++;
					sum = 0;
				}
				sum += lectures[i];
			}
			if (sum != 0)
				count++;

			if (count <= m) { // 블루레이가 적다
				max = mid - 1;
			} else { // 블루레이가 많다 -> 블루레이 크기 늘려야한다
				min = mid + 1;
			}
		}

		System.out.println(min);
	}
}

// strategy
// 이분탐색 대상 : 블루레이 크기
// 가능한 블루레이의 크기 중 최소 : lower-bound
// 블루레이 크기 -> long
// max
