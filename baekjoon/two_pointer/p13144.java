package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13144 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[100_004];
		int left = 0, right = 0;
		long count = 0;
		while (right < n) {
			while (visited[num[right]]) {
				visited[num[left++]] = false;
			}
			visited[num[right]] = true;
			count += right - left + 1;
			right++;
		}

		System.out.println(count);
	}
}
