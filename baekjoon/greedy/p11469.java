package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11469 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(input[0]);
			arr[i][1] = Integer.parseInt(input[1]);
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

		int lastTime = 0;
		for (int i = 0; i < n; i++) {
			if (lastTime <= arr[i][0]) {
				lastTime = arr[i][0] + arr[i][1];
			} else {
				lastTime += arr[i][1];
			}
		}

		System.out.println(lastTime);
	}
}
