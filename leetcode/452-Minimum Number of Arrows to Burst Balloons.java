import java.util.Arrays;

class Solution {
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});

		int min = points[0][0];
		int max = points[0][1];

		int arrows = 1;
		for (int i = 1; i < points.length; i++) {
			int[] next = points[i];
			if (max < next[0]) {
				arrows++;
				min = next[0];
				max = next[1];
				continue;
			}
			// 겹침
			min = Math.max(min, next[0]);
			max = Math.min(max, next[1]);
		}

		return arrows;
	}
}

// 풍선 모두 터뜨리는 최소 횟수
// min1, max1 vs min2, max2
// 겹침 = max1 > min2 || max2 > min1
// min, max 정렬
// max < min -> arrows++; min,max 갱신
