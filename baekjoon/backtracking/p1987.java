package baekjoon.backtracking;

/*
1. 아이디어
- R*C
- 중복된 알파벳 칸을 지나지 않으면서 이동하는 최대 거리
- 이미 지난 알파벳 지나지 않음 -> 백트래킹
- 왔던 곳으로 가지 않음
- 종료 조건 : 이동불가
2. 시간복잡도
- N * M
3. 자료구조
- 탐색: char[][]
- 결과: int
- 지나온 알파벳: Set<Character>
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1987 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static final boolean[] visited = new boolean[26];

    private static char[][] board;
    private static int R;
    private static int C;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]); // 세로
        C = Integer.parseInt(inputs[1]); // 가로
        board = new char[R][C];


        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited[(board[0][0]) - 'A'] = true;
        recur(0, 0);
        System.out.print(max);
    }

    private static void recur(int x, int y) {
        // 종료조건 = 갈곳없음
        Stack<Point> moving = findMove(x, y);
        if (moving.isEmpty()) {
            max = Math.max(countVisited(), max);
            return;
        }

        while (!moving.isEmpty()) {
            Point next = moving.pop();
            visited[board[next.y][next.x] - 'A'] = true;
            recur(next.x, next.y);
            visited[board[next.y][next.x] - 'A'] = false;
        }
    }

    private static Stack<Point> findMove(int x, int y) {
        Stack<Point> canMove = new Stack<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                continue;
            }
            if (visited[(board[ny][nx]) - 'A']) {
                continue;
            }
            canMove.add(new Point(nx, ny));
        }
        return canMove;
    }

    private static int countVisited() {
        int count = 0;
        for (boolean v : visited) {
            if (v) count++;
        }
        return count;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
