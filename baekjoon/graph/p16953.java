package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16953 {

	private static long b;
	private static long a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());

		int answer = bfs();
		System.out.println(answer);
	}

	static int bfs() {
		Queue<Long> q = new LinkedList<>();
		q.add(a);
		int count = 0;

		while (!q.isEmpty()) {
			count++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				long p = q.poll();
				if (p == b)
					return count;
				if (p > b)
					continue;
				q.add(p * 2);
				q.add(p * 10 + 1);
			}
		}
		return -1;
	}
}
