package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p7562 {

	private static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	private static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

	private static boolean[][] visited;
	private static int size;
	private static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			size = Integer.parseInt(br.readLine());
			board = new int[size][size];
			visited = new boolean[size][size];

			String[] inputs = br.readLine().split(" ");
			int startY = Integer.parseInt(inputs[0]);
			int startX = Integer.parseInt(inputs[1]);
			board[startY][startX] = -1; // 출발점

			inputs = br.readLine().split(" ");
			int endY = Integer.parseInt(inputs[0]);
			int endX = Integer.parseInt(inputs[1]);
			board[endY][endX] = 1; // 도착점

			if (startX == endX && startY == endY) {
				System.out.println(0);
				continue;
			}

			bfs(startX, startY);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, 0));
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= size || ny >= size || visited[ny][nx]) {
					continue;
				}
				if (board[ny][nx] == 1) {
					System.out.println(current.count + 1);
					return;
				}
				visited[ny][nx] = true;
				queue.add(new Node(nx, ny, current.count + 1));
			}
		}
	}

	static class Node {
		int x;
		int y;
		int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}

// strategy
// bfs
//

