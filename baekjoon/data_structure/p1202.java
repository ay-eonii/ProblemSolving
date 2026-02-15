package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class p1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);

		Jewelry[] a = new Jewelry[N];
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			a[i] = new Jewelry(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
		}
		Arrays.sort(a);

		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int i = 0;
		long total = 0;
		for (int bag : bags) {
			while (i < N && a[i].m <= bag) {
				// 담을 수 있다면
				maxHeap.add(a[i].v);
				i++;
			}

			if (!maxHeap.isEmpty()) {
				total += maxHeap.poll();
			}
		}

		System.out.println(total);
	}

	static class Jewelry implements Comparable<Jewelry> {
		int m;
		int v;

		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewelry o) {
			return this.m - o.m;
		}
	}
}
