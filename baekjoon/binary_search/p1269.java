package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[A];
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int i = 0; i < B; i++) {
			boolean exists = find(Integer.parseInt(st.nextToken()), arr);
			if (exists) {
				count++;
			}
		}

		System.out.println(A + B - (count * 2));
	}

	static boolean find(int num, int[] arr) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == num) {
				return true;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}
}
