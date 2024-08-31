package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16236 {

	private static final int[] dx = {0, -1, 1, 0}; // 상 좌 우 하
	private static final int[] dy = {-1, 0, 0, 1}; // 상 좌 우 하
	private static int N;
	private static int[][] space;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		int babyX = 0;
		int babyY = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 9) {
					babyX = j;
					babyY = i;
					space[i][j] = 0;
				}
			}
		}

		int size = 2; // 상어 크기
		int count = 0; // 해당 크기에서 몇개 먹었는지
		int second = 0;
		while (size > count) {
			Point result = hunt(babyX, babyY, size);
			if (result.distance != 0) { // 사냥함
				count++;
				second += result.distance;
				if (size == count) { // 사이즈만큼 먹음
					count = 0;
					size++;
				}
				space[result.y][result.x] = 0;
			} else { // 사냥못함
				System.out.println(second);
				return;
			}
			babyX = result.x;
			babyY = result.y;
		}
	}

	private static Point hunt(int babyX, int babyY, int babySize) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		queue.add(new Point(babyX, babyY, 0));
		visited[babyY][babyX] = true;

		Point destination = new Point(21, 21, 0);
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (space[current.y][current.x] != 0 && babySize > space[current.y][current.x]) {
				if (destination.distance != 0 && current.distance > destination.distance) {
					return destination;
				}
				if (current.y < destination.y || (current.y == destination.y && current.x < destination.x)) {
					// 위에 있는 물고기, 왼쪽에 있는 물고기 우선
					destination = current;
				}
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx]) {
					continue;
				}
				if (babySize < space[ny][nx]) {
					continue;
				}
				visited[ny][nx] = true;
				queue.add(new Point(nx, ny, current.distance + 1));
			}
		}
		return destination;
	}

	static class Point {
		int x;
		int y;
		int distance;

		public Point(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
}

// strategy
// N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리
// 처음 아기 상어의 크기는 2
// 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
// 거리가 가장 가까운 물고기 -> 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기
// 아기 상어는 **자신의 크기와 같은 수의 물고기**를 먹을 때 마다 크기가 1 증가
// 그래프 탐색
// bfs

// 5 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 * 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0

// 5 4 0 0 3 4
// 4 0 0 3 4 5
// 3 2 * 5 6 6
// 2 0 0 3 4 5
// 3 2 0 6 5 4
// 6 6 6 6 6 6
