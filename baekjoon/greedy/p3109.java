package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3109 {

    private static final int[] dy = {-1, 0, 1};
    private static int C;
    private static int R;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]); // 행
        C = Integer.parseInt(inputs[1]); // 열
        map = new char[R][C];
        for (int i = 0; i < R; i++) { // 행
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean dfs(int row, int col) {
        for (int i = 0; i < 3; i++) {
            int nx = col + 1;
            int ny = row + dy[i];
            if (ny < 0 || ny >= R || nx >= C || nx < 0) {
                continue;
            }

            if (map[ny][nx] == '.') {
                if (nx == C - 1) {
                    return true;
                }
                map[ny][nx] = '-';
                if (dfs(ny, nx)) return true;
            }
        }
        return false;
    }
}

// strategy
// 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결
// 가능한 위로
// dfs
// 그리디
