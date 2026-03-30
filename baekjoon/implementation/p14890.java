package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14890 {

	private static int[][] arr;
	private static int n;
	private static int l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (check(i)) {
				answer++;
			}
		}

		arr = turn();
		for (int i = 0; i < n; i++) {
			if (check(i)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	static boolean check(int t) {
		int sameCount = 1;
		boolean down = false;
		for (int i = 1; i < n; i++) {
			if (down && sameCount == l) {
				down = false;
				sameCount = 0;
			}
			if (arr[t][i] == arr[t][i - 1]) {
				sameCount++;
			} else if (arr[t][i] - arr[t][i - 1] == 1) {
				if (sameCount < l) {
					return false;
				}
				if (down) {
					return false;
				}
				sameCount = 1;
			} else if (arr[t][i - 1] - arr[t][i] == 1) {
				if (down) {
					return false;
				}
				down = true;
				sameCount = 1;
			} else {
				return false;
			}
		}
		return !down || sameCount >= l;
	}

	static int[][] turn() {
		int[][] ret = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ret[i][j] = arr[j][i];
			}
		}

		return ret;
	}
}

// 오르는 경우
// 연속된 높이 개수 == L
// h[i] - h[i-1] == 1

// 내리는 경우
// h[i] - h[i+1] == 1
// h[i+1]...h[i+L] 같은 높이

// 종료조건
// 높이 2 이상 차이
// 높이 1 차이지만 i-L < 0 || i+L >= n
// L 이상의 연속된 높이 변화
