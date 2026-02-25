package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p1644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean[] num = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (num[i]) {
				continue;
			}
			for (int j = 2; j * i <= n; j++) {
				num[j * i] = true;
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (num[i]) {
				continue;
			}
			list.add(i);
		}

		int sum = 0;
		int count = 0;
		int left = 0;
		int right = 0;

		while (left <= right) {
			if (sum == n) {
				count++;
			}
			if (sum <= n) {
				if (right >= list.size()) {
					break;
				}
				sum += list.get(right);
				right++;
			} else {
				sum -= list.get(left);
				left++;
			}

		}
		System.out.println(count);
	}
}
