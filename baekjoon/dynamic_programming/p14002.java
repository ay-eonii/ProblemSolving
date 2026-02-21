package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class p14002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[N];
		Arrays.fill(cnt, 1);
		int[] prev = new int[N];
		Arrays.fill(prev, -1);
		int ret = 1;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && cnt[i] < cnt[j] + 1) {
					cnt[i] = cnt[j] + 1;
					prev[i] = j;
					if (ret < cnt[i]) {
						ret = cnt[i];
						idx = i;
					}
				}
			}
		}
		System.out.println(ret);

		Stack<Integer> stack = new Stack<>();
		while (idx != -1) {
			stack.push(arr[idx]);
			idx = prev[idx];
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		System.out.println(sb);
	}
}

//
