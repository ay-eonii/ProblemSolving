import java.util.*;

class Solution {

	int[] parent;

	public int solution(int n, int[][] costs) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

		int total = 0;
		for (int[] cost : costs) {
			if (union(cost[0], cost[1])) {
				total += cost[2];
				continue;
			}
		}

		return total;
	}

	int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return false;
		}

		parent[b] = a;
		return true;
	}
}
