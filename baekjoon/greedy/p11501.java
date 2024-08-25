package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] stocks = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				stocks[j] = Integer.parseInt(st.nextToken());
			}

			long answer = 0;
			int max = stocks[n - 1];
			for (int j = n - 2; j >= 0; j--) {
				if (stocks[j] <= max) {
					answer += max - stocks[j];
				} else {
					max = stocks[j];
				}
			}

			System.out.println(answer);
		}
	}
}

// strategy
// 그리디
