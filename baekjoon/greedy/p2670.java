package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2670 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		double b = arr[0];
		double max = b;
		for (int i = 1; i < N; i++) {
			if (arr[i] > b * arr[i]) {
				b = arr[i];
			} else {
				b *= arr[i];
			}
			max = Math.max(max, b);
		}

		System.out.printf("%.3f", max);
	}
}
