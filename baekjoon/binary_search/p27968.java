package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p27968 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]); // 아이 수
		int m = Integer.parseInt(inputs[1]); // 꺼내는 횟수

		long[] handCandies = new long[m + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			handCandies[i] = handCandies[i - 1] + Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			long want = Long.parseLong(br.readLine());

			int min = 1;
			int max = m;
			int answer = 0;
			while (min <= max) {
				int mid = (min + max) / 2;
				if (handCandies[mid] >= want) { // 더 적게 꺼내도 됨
					answer = mid;
					max = mid - 1;
				} else {
					min = mid + 1;
				}
			}

			if (answer == 0) {
				sb.append("Go away!").append("\n");
			} else {
				sb.append(answer).append("\n");
			}
		}
		System.out.print(sb);
	}
}

// strategy
// 사탕 누적합
// 원하는 사탕 수를 대상으로 이분탐색
// 꺼내는 사탕 -> int -> 합:long
// 받고싶은 사탕 -> long
