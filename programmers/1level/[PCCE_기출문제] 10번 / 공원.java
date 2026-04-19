import java.util.Arrays;

class Solution {

	static int r;
	static int c;

	public int solution(int[] mats, String[][] park) {
		Arrays.sort(mats);
		r = park.length;
		c = park[0].length;

		for (int m = mats.length - 1; m >= 0; m--) {
			int matSize = mats[m];

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (check(i, j, park, matSize)) {
						return matSize;
					}
				}
			}
		}

		return -1;
	}

	public boolean check(int i, int j, String[][] park, int mat) {
		for (int y = 0; y < mat; y++) {
			for (int x = 0; x < mat; x++) {
				if (i + y >= r || j + x >= c) {
					return false;
				}
				if (!"-1".equals(park[i + y][j + x])) {
					return false;
				}
			}
		}

		return true;
	}
}
