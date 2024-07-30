package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		while (end < n) {
			int diff = arr[end] - arr[start];
			if (diff < m) {
				end++;
			} else if (diff > m) {
				min = Math.min(diff, min);
				start++;
			} else {
				min = m;
				break;
			}
		}

		System.out.println(min);
	}
}

// strategy
// 두 수의 차이가 M 이상이면서 제일 작은 경우
// 투 포인터
// 정렬
// 1. 차이가 M 이상이라면
// 지금 최소보다 작다면 -> 범위 좁혀서
// .. 크다면 -> 현재 값
// 2. 차이가 M 이하라면

