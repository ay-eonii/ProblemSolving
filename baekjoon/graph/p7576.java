package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {

    private static final int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static final int[] dy = {1, -1, 0, 0}; // 상하좌우

    private static int[][] TOMATOES;
    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]); //가로
        N = Integer.parseInt(inputs[1]); //세로

        TOMATOES = new int[N][M];
        Queue<Tomato> queue = new LinkedList<>();
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                TOMATOES[y][x] = Integer.parseInt(st.nextToken());
                if (TOMATOES[y][x] == 1) {
                    queue.add(new Tomato(x, y, 0));
                }
            }
        }

        int day = bfs(queue);

        for (int[] tomato : TOMATOES) {
            for (int t : tomato) {
                if (t == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day);
    }

    private static int bfs(Queue<Tomato> queue) {
        int day = 0;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                day = tomato.day;

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (TOMATOES[ny][nx] == 0) {
                    TOMATOES[ny][nx] = 1;
                    queue.add(new Tomato(nx, ny, day + 1));
                }
            }
        }

        return day;
    }

    private static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}

// strategy
// bfs
