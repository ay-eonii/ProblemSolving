class Solution {
	// 우 하 좌 상
	public static final int[] dx = {1, 0, -1, 0};
	public static final int[] dy = {0, 1, 0, -1};

	public int[] solution(int rows, int columns, int[][] queries) {
		int y = rows;
		int x = columns;
		int[][] map = new int[y][x];

		// 초기화
		int num = 1;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				map[i][j] = num;
				num++;
			}
		}

		// 타겟구하기
		int c = queries.length;
		int[] answer = new int[c];
		for (int t = 0; t < c; t++) {
			int min = getTargets(map, queries[t]);
			answer[t] = min;
		}

		return answer;
	}

	private int getTargets(int[][] map, int[] query) {
		int y1 = query[0] - 1;
		int x1 = query[1] - 1;
		int y2 = query[2] - 1;
		int x2 = query[3] - 1;

		int[][] ret = new int[map.length][map[0].length];

		int d = 0;
		int x = x1;
		int y = y1;

		int prev = map[y][x];
		int min = prev;
		while (d < 4) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 범위 넘으면 방향 전환
			if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
				d++;
				continue;
			}

			// x,y 값을 nx,ny에 넣기
			int tmp = map[ny][nx];
			map[ny][nx] = prev;
			prev = tmp;
			min = Math.min(min, prev);

			y = ny;
			x = nx;
		}

		return min;
	}
}

// 1. 타겟구하기 && 최소값 구하기
// 2. 회전하기
// 3. 1,2 반복

// 방향 : 우 하 좌 상
// dx : 1 0 -1 0
// dy : 0 1 0 -1

// 각 인덱스에 대해 방향이 정해짐
// if (y1 && x != x2) : 우
// if (x2 && y != y2) : 하
// if (y2 && x != x1) : 좌
// if (x1 && y != y1) : 상
