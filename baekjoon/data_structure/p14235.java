package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p14235 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			if ("0".equals(input[0])) {
				if (!maxHeap.isEmpty()) {
					sb.append(maxHeap.poll() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			} else {
				for (int j = 1; j < input.length; j++) {
					maxHeap.add(Integer.parseInt(input[j]));
				}
			}
		}

		System.out.print(sb);
	}
}

//
