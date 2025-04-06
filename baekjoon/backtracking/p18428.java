package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p18428 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static int n;
    private static char[][] hallway;
    private static String answer = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        hallway = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < inputs.length; j += 2) {
                hallway[i][j / 2] = inputs[j];
            }
        }

        backTracking(0, 0, 0);
        System.out.println(answer);
    }

    private static void backTracking(int obstacle, int x, int y) {
        if (obstacle == 3) {
            if (!watch()) {
                answer = "YES";
            }
            return;
        }

        for (int i = x; i < n; i++) { // 같은 행
            if (hallway[y][i] != 'X') {
                continue;
            }

            hallway[y][i] = 'O';
            backTracking(obstacle + 1, i + 1, y);
            hallway[y][i] = 'X';
        }

        for (int i = y + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hallway[i][j] != 'X') {
                    continue;
                }

                hallway[i][j] = 'O';
                backTracking(obstacle + 1, j + 1, i);
                hallway[i][j] = 'X';
            }
        }
    }

    public static boolean watch() {
        for (int i = 0; i < n; i++) { // 행
            for (int j = 0; j < n; j++) { // 열
                if (hallway[i][j] != 'T') {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    while (nx >= 0 && ny >= 0 && nx < n && ny < n && hallway[ny][nx] != 'O') {
                        if (hallway[ny][nx] == 'S') {
                            return true;
                        }
                        nx += dx[k];
                        ny += dy[k];
                    }
                }
            }
        }
        return false;
    }
}
