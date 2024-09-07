package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17484 {

    private static final int[] dx = {-1, 0, 1}; // 왼하, 중하, 오하
    private static int[][] fuel;
    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 행
        M = Integer.parseInt(inputs[1]); // 열

        fuel = new int[N][M];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                fuel[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x = 0; x < M; x++) {
            min = Math.min(min, bfs(x));
        }
        System.out.println(min);
    }

    private static int bfs(int x) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(x, 0, fuel[0][x], 2));

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Move current = queue.poll();
            if (current.y + 1 == N) {
                min = Math.min(min, current.energy);
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + 1;
                if (nx < 0 || nx >= M || ny >= N || current.direction == dx[i]) {
                    continue;
                }
                queue.add(new Move(nx, ny, current.energy + fuel[ny][nx], dx[i]));
            }
        }
        return min;
    }

    static class Move {
        int x;
        int y;
        int energy;
        int direction;

        public Move(int x, int y, int energy, int direction) {
            this.x = x;
            this.y = y;
            this.energy = energy;
            this.direction = direction;
        }
    }
}

// strategy
// 지구 -> 달로 가는 경우 우주선이 움직일 수 있는 방향: 왼쪽 아래, 중간 아래, 오른쪽 아래
// 같은 방향으로 두번 연속으로 움직일 수 없다.
// bfs
