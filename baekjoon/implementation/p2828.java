package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int J = Integer.parseInt(br.readLine());

		int left = 0;
		int right = M;
		int answer = 0;
		for (int i = 0; i < J; i++) {
			int apple = Integer.parseInt(br.readLine());
			int move = 0;
			if (left >= apple) {
				move = left - apple + 1;
				left -= move;
				right -= move;
			} else if (right < apple) {
				move = apple - right;
				left += move;
				right += move;
			}

			answer += move;
		}

		System.out.println(answer);
	}
}
