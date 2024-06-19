package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14940 {

    private static final int[] dx = {0, 0, -1, 1};// 상하좌우
    private static final int[] dy = {1, -1, 0, 0};// 상하좌우
    private static boolean[][] VISITED;
    private static int N;
    private static int M;
    private static Integer[][] ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 세로
        M = Integer.parseInt(inputs[1]); // 가로

        Area start = new Area(0, 0);
        int[][] map = new int[N][M];
        VISITED = new boolean[N][M];
        ANSWER = new Integer[N][M];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    start = new Area(x, y); // 시작 위치
                }
                if (map[y][x] == 0) {
                    VISITED[y][x] = true;
                    ANSWER[y][x] = 0;
                }
            }
        }

        bfs(start);

        StringBuilder sb = new StringBuilder();
        for (Integer[] a : ANSWER) {
            for (Integer i : a) {
                if (i == null) {
                    i = -1;
                }
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void bfs(Area start) {
        Queue<Area> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start.y][start.x] = true;
        ANSWER[start.y][start.x] = 0;
        while (!queue.isEmpty()) {
            Area current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !VISITED[ny][nx]) {
                    queue.add(new Area(nx, ny));
                    VISITED[ny][nx] = true;
                    ANSWER[ny][nx] = ANSWER[current.y][current.x] + 1;
                }
            }
        }
    }

    static class Area {
        int x;
        int y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// strategy
// 2부터 시작
// 상하좌우 : +1
