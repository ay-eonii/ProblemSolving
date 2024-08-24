package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p8979 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);

		Country[] countries = new Country[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			countries[i] = new Country(number, gold, silver, bronze);
		}

		Arrays.sort(countries);

		int rank = 1;
		int same = 1;
		if (countries[0].number == k) {
			System.out.println(rank);
			return;
		}

		for (int i = 1; i < n; i++) {
			if (countries[i].compareTo(countries[i - 1]) != 0) {
				rank += same;
				same = 1;
			} else {
				same++;
			}
			if (countries[i].number == k) {
				System.out.println(rank);
				return;
			}
		}
	}

	static class Country implements Comparable<Country> {
		int number;
		int gold;
		int silver;
		int bronze;

		public Country(int number, int gold, int silver, int bronze) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		public int sum() {
			return gold + silver + bronze;
		}

		@Override
		public int compareTo(Country o) {
			if (gold > o.gold) {
				return -1;
			} else if (gold == o.gold) {
				if (silver > o.silver) {
					return -1;
				} else if (silver == o.silver) {
					if (bronze > o.bronze) {
						return -1;
					} else if (bronze == o.bronze) {
						if (sum() > o.sum()) {
							return -1;
						} else if (sum() == o.sum()) {
							return 0;
						}
						return 1;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}

// strategy
// 정렬
