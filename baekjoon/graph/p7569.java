package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7569 {
    //위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {0, 0, 0, 0, -1, 1};
    private static final int[] dz = {1, -1, 0, 0, 0, 0};
    private static int M;
    private static int N;
    private static int H;
    private static int[][][] TOMATOES;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]); // 가로
        N = Integer.parseInt(inputs[1]); // 세로
        H = Integer.parseInt(inputs[2]); // 높이

        TOMATOES = new int[N][M][H];
        Queue<Point> queue = new LinkedList<>();
        boolean allDone = true;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    TOMATOES[y][x][z] = Integer.parseInt(st.nextToken());
                    if (TOMATOES[y][x][z] == 0) {
                        allDone = false;
                    }
                    if (TOMATOES[y][x][z] == 1) {
                        queue.add(new Point(x, y, z, 0));
                    }
                }
            }
        }

        if (allDone) {
            System.out.print(0);
            return;
        }

        int day = bfs(queue);

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (TOMATOES[y][x][z] == 0) {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }

        System.out.print(day);
    }

    static int bfs(Queue<Point> queue) {
        int day = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];
                day = current.day;
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H
                        && TOMATOES[ny][nx][nz] == 0) {
                    queue.add(new Point(nx, ny, nz, day + 1));
                    TOMATOES[ny][nx][nz] = 1;
                }
            }
        }

        return day;
    }

    static class Point {
        int x;
        int y;
        int z;
        int day;

        public Point(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}

// strategy
// 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
// 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력
// bfs
