import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int max = 0;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		recur(map, 0);

		System.out.println(max);
	}

	private static void recur(int[][] map, int c) {
		if (c == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			int[][] rotated = map;
			for (int t = 0; t < d; t++) {
				// 돌리기
				rotated = turn(rotated);
			}

			// 밀기
			int[][] moved = moveLeft(rotated);
			recur(moved, c + 1);
		}
	}

	private static int[][] turn(int[][] map) {
		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp[j][n - 1 - i] = map[i][j];
			}
		}

		return tmp;
	}

	private static int[][] moveLeft(int[][] map) {
		int[][] sum = new int[n][n];
		for (int i = 0; i < n; i++) {
			int idx = 0;
			int[] tmp = new int[n];
			for (int j = 0; j < n; j++) {
				int target = map[i][j];
				if (target == 0) {
					continue;
				}
				if (tmp[idx] == 0) {
					tmp[idx] = target;
				} else if (tmp[idx] == target) {
					tmp[idx] = target * 2;
					idx++;
				} else {
					idx++;
					tmp[idx] = target;
				}
			}
			sum[i] = tmp;
		}

		return sum;
	}
}
