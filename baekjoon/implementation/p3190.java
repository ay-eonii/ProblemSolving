package baekjoon.implementation;

/*
1. 아이디어
- 단순 구현/계산
- 방문 기록은 필요 X
- 현재 점유 위치 파악 (머리 - 몸 - 꼬리)
- queue에 저장
- 벽이나 몸에 부딪힐 때까지 (꼬리 줄이기 전에 부딪힐 수 있음) -> queue.contains
- dfs
2. 시간복잡도
3. 자료구조
- 뱀: Queue<Point>
- 위치: Point{x,y}
- 시간: int
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class p3190 {

    private static final int[] dx = {0, -1, 0, 1}; // 상좌하우
    private static final int[] dy = {-1, 0, 1, 0};
    private static final Map<Integer, Character> directions = new HashMap<>();
    private static final Queue<Point> snake = new LinkedList<>();
    private static int direction = 3;
    private static int N;
    private static int answer = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // board
        map = new int[N][N];
        int K = Integer.parseInt(br.readLine()); // apple
        for (int i = 0; i < K; i++) {
            String[] inputs = br.readLine().split(" "); // y, x
            map[Integer.parseInt(inputs[0]) - 1][Integer.parseInt(inputs[1]) - 1] = 2;
        }

        int L = Integer.parseInt(br.readLine()); // direction
        for (int i = 0; i < L; i++) {
            String[] inputs = br.readLine().split(" "); // X, C
            directions.put(Integer.parseInt(inputs[0]), inputs[1].charAt(0));
        }

        map[0][0] = 1;
        Point start = new Point(0, 0);
        snake.add(start);
        Point next = next(start);
        while (true) {
            if (!canMove(next)) {
                break;
            }
            answer++;
            next = move(next);
        }

        System.out.print(answer + 1);
    }

    private static boolean canMove(Point next) {
        if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) {
            return false;
        }

        return map[next.y][next.x] != 1; // 몸에 부딪히는지
    }

    private static Point move(Point next) {
        snake.add(next);
        if (directions.get(answer) != null) {
            if (directions.get(answer) == 'L') {
                direction = (direction + 1) % 4;
            }
            if (directions.get(answer) == 'D') {
                direction = (direction + 3) % 4;
            }
        }
        if (map[next.y][next.x] == 2) { // 사과있으면 먹고 끝
            map[next.y][next.x] = 1;
            return next(next);
        }
        // 사과 없으면 줄이기
        Point poll = snake.poll();
        map[poll.y][poll.x] = 0;
        map[next.y][next.x] = 1;
        return next(next);
    }

    private static Point next(Point current) {
        int nx = current.x + dx[direction];
        int ny = current.y + dy[direction];
        return new Point(nx, ny);
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
