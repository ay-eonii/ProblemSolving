package baekjoon.backtracking;

import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p15686 {

	private static int N;
	private static int M;
	private static int answer = Integer.MAX_VALUE;
	private static int[][] city;
	private static List<Place> houses;
	private static List<Place> chickens;
	private static List<Boolean> open;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		chickens = new ArrayList<>();
		open = new ArrayList<>();
		houses = new ArrayList<>();
		city = new int[N][N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				city[y][x] = Integer.parseInt(st.nextToken());
				if (city[y][x] == 2) {
					chickens.add(new Place(x, y));
					open.add(false);
				}
				if (city[y][x] == 1) {
					houses.add(new Place(x, y));
				}
			}
		}

		combine(0, 0);
		System.out.print(answer);
	}

	private static void combine(int start, int count) {
		if (count == M) {
			int sum = 0;
			for (Place house : houses) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < open.size(); i++) {
					if (open.get(i)) {
						Place chicken = chickens.get(i);
						min = Math.min(abs(chicken.x - house.x) + abs(chicken.y - house.y), min);
					}
				}
				sum += min;
			}

			answer = Math.min(sum, answer);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			open.set(i, true);
			combine(i + 1, count + 1);
			open.set(i, false);
			combine(i + 1, count);
		}
	}

	static class Place {
		int x;
		int y;

		public Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

// strategy
// 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
// 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|
// 0은 빈 칸, 1은 집, 2는 치킨집
// 가장 작은 치킨 거리를 두고 치킨집 M 개 남기기
// 도시의 치킨 거리의 최솟값 구하기: 모든 집 간 치킨 거리의 합

// 2인 곳에 M개 지점두고
// 도시의 치킨 거리 구하기
// backtracking
