package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p3197 {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, -0, 0};
	private static char[][] lake;
	private static boolean[][] visitedWater;
	private static boolean[][] visitedSwan;
	private static int r;
	private static int c;
	private static Queue<int[]> waterQ;
	private static Queue<int[]> swanQ;
	private static Queue<int[]> swanTemp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);

		waterQ = new LinkedList<>();
		swanQ = new LinkedList<>();
		visitedWater = new boolean[r][c];
		visitedSwan = new boolean[r][c];
		lake = new char[r][c];
		for (int i = 0; i < r; i++) {
			lake[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (lake[i][j] == 'L' && swanQ.isEmpty()) {
					swanQ.add(new int[] {i, j});
				}
				if (lake[i][j] == '.' || lake[i][j] == 'L') {
					visitedWater[i][j] = true;
					waterQ.add(new int[] {i, j});
				}
			}
		}

		int count = 0;
		swanTemp = new LinkedList<>();
		while (!check()) {
			swanQ = swanTemp;
			swanTemp = new LinkedList<>();
			waterQ = bfs();
			count++;
		}

		System.out.println(count);
	}

	static boolean check() {
		while (!swanQ.isEmpty()) {
			int[] here = swanQ.poll();
			visitedSwan[here[0]][here[1]] = true;
			for (int i = 0; i < 4; i++) {
				int nx = here[1] + dx[i];
				int ny = here[0] + dy[i];
				if (nx < 0 || nx >= c || ny < 0 || ny >= r || visitedSwan[ny][nx]) {
					continue;
				}

				visitedSwan[ny][nx] = true;

				if (lake[ny][nx] == 'L') {
					return true;
				}
				if (lake[ny][nx] == 'X') {
					swanTemp.add(new int[] {ny, nx});
				} else if (lake[ny][nx] == '.') {
					swanQ.add(new int[] {ny, nx});
				}
			}
		}

		return false;
	}

	static Queue<int[]> bfs() {
		Queue<int[]> temp = new LinkedList<>();
		while (!waterQ.isEmpty()) {
			int[] here = waterQ.poll();
			visitedWater[here[0]][here[1]] = true;
			for (int i = 0; i < 4; i++) {
				int nx = here[1] + dx[i];
				int ny = here[0] + dy[i];
				if (nx < 0 || nx >= c || ny < 0 || ny >= r || visitedWater[ny][nx]) {
					continue;
				}

				if (lake[ny][nx] == 'X') {
					lake[ny][nx] = '.';
					visitedWater[ny][nx] = true;
					temp.add(new int[] {ny, nx});
				}
			}
		}
		return temp;
	}
}
