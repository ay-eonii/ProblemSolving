import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};
	private static int len;
	private static boolean[][] visited;
	private static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);

		len = (int)Math.pow(2, n);

		int[][] map = new int[len][len];
		for (int i = 0; i < len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// System.out.print(map[i][j] + " ");
			}
			// System.out.println();
		}

		int[] levels = new int[q];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			levels[i] = Integer.parseInt(st.nextToken());
		}

		// 1. 회전하기
		for (int l : levels) {
			rotate(l, map, 0, 0, len);

			// 2. 얼음 녹이기
			int[][] melt = new int[len][len];
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					int count = 0;
					for (int d = 0; d < 4; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];
						if (nx < 0 || nx >= len || ny < 0 || ny >= len) {
							continue;
						}
						if (map[ny][nx] != 0) {
							count++;
						}
					}

					melt[i][j] = map[i][j];

					if (count < 3 && melt[i][j] > 0) {
						melt[i][j]--;
					}
				}
			}

			map = melt;
		}

		// 3. 군집구하기 (dfs)
		int sum = 0;
		visited = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				sum += map[i][j];
				if (visited[i][j] || map[i][j] == 0) {
					continue;
				}
				visited[i][j] = true;
				max = Math.max(dfs(map, j, i), max);
			}
		}

		System.out.println(sum);
		System.out.println(max);
	}

	private static int dfs(int[][] map, int x, int y) {
		int size = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= len || ny < 0 || ny >= len || visited[ny][nx]) {
				continue;
			}

			if (map[ny][nx] == 0) {
				continue;
			}

			visited[ny][nx] = true;
			size += dfs(map, nx, ny);
		}

		return size;
	}

	private static void rotate(int level, int[][] map, int startX, int startY, int size) {
		if (size == 0) {
			return;
		}

		if (size == Math.pow(2, level)) {
			int h = size / 2;

			int[][] tmp = new int[size][size];
			for (int i = 0; i < size; i++) {
				System.arraycopy(map[startY + i], startX, tmp[i], 0, size);
			}

			// 조각 이동 (평행이동)
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < h; j++) {
					map[startY + i][startX + j + h] = tmp[i][j]; // 좌 -> 우
					map[startY + i + h][startX + h + j] = tmp[i][j + h]; // 우 -> 하
					map[startY + i + h][startX + j] = tmp[i + h][j + h]; // 하 -> 좌
					map[startY + i][startX + j] = tmp[i + h][j]; // 하 -> 상
				}
			}

			return;
		}

		int nextSize = size / 2;
		rotate(level, map, startX, startY, nextSize);
		rotate(level, map, startX + nextSize, startY, nextSize);
		rotate(level, map, startX, startY + nextSize, nextSize);
		rotate(level, map, startX + nextSize, startY + nextSize, nextSize);
	}
}
