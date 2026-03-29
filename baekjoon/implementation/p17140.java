package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class p17140 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		List<List<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			List<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			arr.add(list);
		}

		int count = 0;
		while (true) {
			if (r < arr.size() && c < arr.get(0).size() && arr.get(r).get(c) == k) {
				break;
			}

			if (arr.size() >= arr.get(0).size()) {
				arr = sort(arr);
			} else {
				arr = swipe(arr);
				arr = sort(arr);
				arr = swipe(arr);
			}
			count++;
			if (count > 100) {
				break;
			}
		}

		System.out.println(count > 100 ? -1 : count);

	}

	static List<List<Integer>> swipe(List<List<Integer>> arr) {
		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0; i < arr.get(0).size(); i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < arr.size(); j++) {
				list.add(arr.get(j).get(i));
			}
			ret.add(list);
		}

		return ret;
	}

	static List<List<Integer>> sort(List<List<Integer>> arr) {
		List<List<Integer>> ret = new ArrayList<>();
		int max = 3;
		for (int i = 0; i < arr.size(); i++) {
			List<Integer> iList = arr.get(i);
			Map<Integer, Pair> map = new HashMap<>();
			for (int j = 0; j < iList.size(); j++) {
				int key = iList.get(j);
				if (key == 0) {
					continue;
				}
				Pair value = map.getOrDefault(key, new Pair(key, 0));
				value.count += 1;
				map.put(key, value);
			}

			List<Pair> pairs = new ArrayList<>(map.values());
			pairs.sort((o1, o2) -> {
				if (o1.count == o2.count) {
					return o1.n - o2.n;
				}
				return o1.count - o2.count;
			});

			ArrayList<Integer> list = new ArrayList<>();
			for (Pair pair : pairs) {
				list.add(pair.n);
				list.add(pair.count);
			}

			max = Math.max(max, list.size());
			ret.add(list);
		}

		for (int i = 0; i < ret.size(); i++) {
			int size = ret.get(i).size();
			for (int j = size; j < max; j++) {
				ret.get(i).add(0);
			}
		}

		return ret;
	}

	static class Pair {
		int n;
		int count;

		public Pair(int n, int count) {
			this.n = n;
			this.count = count;
		}
	}
}
