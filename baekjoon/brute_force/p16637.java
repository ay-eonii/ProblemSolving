package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16637 {

	private static int n;
	private static int[] num;
	private static char[] oper;
	private static int ret = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n / 2 + 1];
		oper = new char[n / 2];
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				num[i / 2] = Character.getNumericValue(input[i]);
			} else {
				oper[i / 2] = input[i];
			}
		}

		go(0, num[0]);

		System.out.println(ret);
	}

	static void go(int here, int prev) {
		if (here == num.length - 1) {
			ret = Math.max(ret, prev);
			return;
		}

		go(here + 1, calc(prev, num[here + 1], oper[here]));
		if (here + 2 <= num.length - 1) {
			int temp = calc(num[here + 1], num[here + 2], oper[here + 1]);
			go(here + 2, calc(prev, temp, oper[here]));
		}
	}

	static int calc(int a, int b, char o) {
		if (o == '+') {
			return a + b;
		} else if (o == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
}
