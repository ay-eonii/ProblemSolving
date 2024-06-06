package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1012 {

    private static final int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    private static final int[] dy = {1, -1, 0, 0}; // 상 하 좌 우
    private static boolean[][] VISITED;
    private static boolean[][] CABBAGE;
    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int p = 0; p < t; p++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            CABBAGE = new boolean[N][M];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                CABBAGE[y][x] = true;
            }

            VISITED = new boolean[N][M];
            int answer = 0;

            for (int i = 0; i < N; i++) { // 세로
                for (int j = 0; j < M; j++) { // 가로
                    if (!VISITED[i][j] && CABBAGE[i][j]) { // 첫 배추
                        answer++;
                        dfs(j, i);
                    }
                }
            }

            System.out.println(answer);
        }

    }

    private static void dfs(int x, int y) {
        if (VISITED[y][x]) {
            return;
        }

        VISITED[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && CABBAGE[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }
}
