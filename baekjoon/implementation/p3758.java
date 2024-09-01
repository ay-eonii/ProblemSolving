package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p3758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int x = 0; x < T; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 팀의 개수
			int k = Integer.parseInt(st.nextToken()); // 문제 개수
			int t = Integer.parseInt(st.nextToken()); // 팀 아이디
			int m = Integer.parseInt(st.nextToken()); // 로그 개수

			Map<Integer, Problems> teams = new HashMap<>();
			for (int z = 1; z <= n; z++) {
				teams.put(z, new Problems(k));
			}
			for (int y = 0; y < m; y++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken()); // 팀 아이디
				int j = Integer.parseInt(st.nextToken()); // 문제 번호
				int s = Integer.parseInt(st.nextToken()); // 획득한 점수

				Problems problems = teams.get(i);
				problems.updateScore(j, s);
				problems.updateLast(y);
			}

			int rank = 1;
			Problems myProblems = teams.get(t);
			int myScore = myProblems.sum();
			int mySubmit = myProblems.submitCount;
			int myLast = myProblems.last;
			for (int i = 1; i <= n; i++) {
				if (i == t) {
					continue;
				}
				Problems other = teams.get(i);
				if (other.sum() > myScore) {
					rank++;
					continue;
				}
				if (other.sum() == myScore && other.submitCount < mySubmit) {
					rank++;
					continue;
				}
				if (other.sum() == myScore && other.submitCount == mySubmit && other.last < myLast) {
					rank++;
				}
			}

			System.out.println(rank);
		}
	}

	static class Problems {
		Map<Integer, Integer> problems;
		int submitCount = 0;
		int last = 0;

		public Problems(int k) {
			this.problems = new HashMap<>();
			for (int i = 1; i <= k; i++) {
				problems.put(i, 0);
			}
		}

		public void updateScore(int id, int score) {
			if (problems.get(id) < score) {
				problems.put(id, score);
			}
			submitCount++;
		}

		public int sum() {
			int total = 0;
			for (Integer value : problems.values()) {
				total += value;
			}
			return total;
		}

		public void updateLast(int y) {
			this.last = y;
		}
	}
}

// strategy
// 팀의 ID, 문제 번호, 점수
