package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p19638 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long H = Long.parseLong(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			maxHeap.add(Long.parseLong(br.readLine()));
		}

		int used = 0;
		while (used < T) {
			if (maxHeap.isEmpty() || maxHeap.peek() == 1 || maxHeap.peek() < H) {
				break;
			}
			maxHeap.add(maxHeap.poll() / 2);
			used++;
		}

		if (!maxHeap.isEmpty() && maxHeap.peek() < H) {
			System.out.println("YES");
			System.out.println(used);
		} else {
			System.out.println("NO");
			System.out.println(maxHeap.peek());
		}
	}
}

// 키: long 2,000,000,000
// 인구: int
// 16 32 -> 16 16 -> 8 16 -> 8 8
