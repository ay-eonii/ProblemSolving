package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (minHeap.size() == maxHeap.size()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}

			if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if (maxHeap.peek() > minHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.add(maxHeap.poll());
					maxHeap.add(tmp);
				}
			}
			sb.append(maxHeap.peek() + "\n");
		}

		System.out.print(sb);
	}
}

// left(max heap)  = 작은 값 절반
// right(min heap) = 큰 값 절반
// left의 모든 값 <= right의 모든 값

// 짝수개 -> 작은 수 출력
// 작은값중 가장 큰값(max heap) 출력
// maxHeap.size() >= minHeap.size()
