package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14889 {
    private static int N;
    private static boolean[] visited;
    private static int[][] spec;
    private static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        spec = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                spec[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(Min);
    }

    private static void combi(int idx, int r) {
        if (r == N / 2) {
            getDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, r + 1);
                visited[i] = false;
            }
        }
    }

    private static void getDiff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += spec[i][j];
                    start += spec[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    link += spec[i][j];
                    link += spec[j][i];
                }
            }
        }
        int diff = Math.abs(start - link);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }
        Min = Math.min(Min, diff);
    }
}