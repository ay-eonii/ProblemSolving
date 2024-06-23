package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14500 {

    private static final int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static final int[] dy = {1, -1, 0, 0}; // 상하좌우
    private static int N;
    private static int M;
    private static int[][] ARR;
    private static boolean[][] VISITED;
    private static int MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);// 행
        M = Integer.parseInt(inputs[1]);// 열

        ARR = new int[N][M];
        VISITED = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                ARR[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        MAX = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                VISITED[y][x] = true;
                dfs(x, y, 1, ARR[y][x]);
                VISITED[y][x] = false;
            }
        }

        System.out.print(MAX);
    }

    private static void dfs(int x, int y, int size, int sum) {
        if (size == 4) {
            MAX = Math.max(sum, MAX);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !VISITED[ny][nx]) {
                if (size == 2) {
                    VISITED[ny][nx] = true;
                    dfs(x, y, size + 1, sum + ARR[ny][nx]);
                    VISITED[ny][nx] = false;
                }
                VISITED[ny][nx] = true;
                dfs(nx, ny, size + 1, sum + ARR[ny][nx]);
                VISITED[ny][nx] = false;
            }
        }
    }
}

// strategy
// 완전탐색 ? 브루트포스
// 해당 위치에서 5가지 도형 비교
// 사이즈 4개될때까지 상하좌우에서 큰쪽으로
// dfs
// Max 찾기
// ㅗ 모양 -> 2일때 이전 위치에서 다시 탐색
//
