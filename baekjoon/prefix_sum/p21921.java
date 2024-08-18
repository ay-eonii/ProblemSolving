package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p21921 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int X = Integer.parseInt(inputs[1]);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] visit = new int[N];
		for (int i = 0; i < N; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}

		int[] sum = new int[N];
		for (int i = 0; i < X; i++) {
			sum[0] += visit[i];
		}

		int max = sum[0];
		int count = 1;
		for (int i = 1; i <= N - X; i++) {
			sum[i] = sum[i - 1] - visit[i - 1] + visit[i + X - 1];
			if (sum[i] == max) {
				count++;
			}
			if (sum[i] > max) {
				max = sum[i];
				count = 1;
			}
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}
	}
}

// strategy
// 누적합
// for (i = 0; i <= N - X)
// visit[i] + ... + visit[i + X - 1]
// if (sum == max) count++
// if (sum > max) count = 1
// max == 0 ? SAD


