package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class p2910 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		long C = Long.parseLong(input[1]);

		Map<Long, Pair> map = new LinkedHashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Long key = Long.parseLong(st.nextToken());
			if (map.containsKey(key)) {
				Pair value = map.get(key);
				map.put(key, new Pair(key, value.count + 1, value.index));
			} else {
				map.put(key, new Pair(key, 1, i));
			}
		}

		List<Pair> list = new ArrayList<>(map.values());
		list.sort((o1, o2) -> {
			if (o1.count == o2.count) {
				return o1.index - o2.index;
			}
			return o2.count - o1.count;
		});

		StringBuilder sb = new StringBuilder();
		for (Pair p : list) {
			for (int i = 0; i < p.count; i++) {
				sb.append(p.v + " ");
			}
		}

		System.out.println(sb);
	}

	static class Pair {
		long v;
		int count;
		int index;

		public Pair(long v, int count, int index) {
			this.v = v;
			this.count = count;
			this.index = index;
		}
	}
}
