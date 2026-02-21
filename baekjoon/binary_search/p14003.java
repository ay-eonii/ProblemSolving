package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class p14003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		long[] lis = new long[N];
		Arrays.fill(lis, Long.MAX_VALUE);
		int len = 0;
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; i++) {
			int index = lowerBound(arr[i], lis);
			if (lis[index] == Long.MAX_VALUE) {
				len++;
			}
			lis[index] = arr[i];
			pairs[i] = new Pair(index, arr[i]);
		}

		System.out.println(len);

		Stack<Long> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (pairs[i].index == len - 1) {
				stack.push(pairs[i].number);
				len--;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		System.out.print(sb);
	}

	static int lowerBound(long number, long[] arr) {
		int min = 0;
		int max = arr.length - 1;
		int ret = arr.length - 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (number <= arr[mid]) {
				max = mid - 1;
				ret = mid;
			} else {
				min = mid + 1;
			}
		}

		return ret;
	}

	static class Pair {
		int index;
		long number;

		public Pair(int index, long number) {
			this.index = index;
			this.number = number;
		}
	}
}

// { 10, 20, 30, 14 }
// lis : {10, --20-- -> 14, 30 }
// -> 순차적으로 넣을 때, 넣는 수 이상이 있다면 replace
// 이상 찾기 : binary search, lower bound

