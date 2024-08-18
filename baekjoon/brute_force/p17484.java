package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17484 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] people = new Person[n];
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			people[i] = new Person(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
		}

		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}
	}

	static class Person {
		int weight;
		int height;

		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}
}

// strategy
