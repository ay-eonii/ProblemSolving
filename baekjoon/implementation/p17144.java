package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17144 {
    private static final int[] dx = {0, 0, -1, 1};// 상하좌우
    private static final int[] dy = {1, -1, 0, 0};// 상하좌우
    private static int[][] ROOM;
    private static int airMachine;
    private static int C;
    private static int R;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]); // 행
        C = Integer.parseInt(inputs[1]); // 열
        int t = Integer.parseInt(inputs[2]); // 초

        ROOM = new int[R][C];
        airMachine = 0;
        for (int y = 0; y < R; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < C; x++) {
                ROOM[y][x] = Integer.parseInt(st.nextToken());
                if (ROOM[y][x] == -1) {
                    airMachine = y;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            // 확산
            int[][] spread = new int[R][C]; // 퍼지기
            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    if (ROOM[y][x] == -1) {
                        continue;
                    }

                    int count = 0;
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
                            continue;
                        }
                        if (ROOM[ny][nx] == -1) {
                            continue;
                        }
                        spread[ny][nx] += ROOM[y][x] / 5;
                        count++;
                    }

                    ROOM[y][x] -= ROOM[y][x] / 5 * count;
                }
            }

            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    ROOM[y][x] += spread[y][x];
                }
            }

            executeAirCleaner();
        }

        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (ROOM[i][j] == -1) continue;
                res += ROOM[i][j];
            }
        }

        System.out.println(res);
    }

    static void executeAirCleaner() {
        // 위쪽 공기청정기는 반시계방향
        int top = airMachine - 1;

        for (int x = top - 1; x > 0; x--) {
            ROOM[x][0] = ROOM[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            ROOM[0][y] = ROOM[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            ROOM[x][C - 1] = ROOM[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            ROOM[top][y] = ROOM[top][y - 1];
        }

        ROOM[top][1] = 0;


        // 아래쪽 공기청정기는 시계 방향
        int bottom = airMachine;

        for (int x = bottom + 1; x < R - 1; x++) {
            ROOM[x][0] = ROOM[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            ROOM[R - 1][y] = ROOM[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            ROOM[x][C - 1] = ROOM[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            ROOM[bottom][y] = ROOM[bottom][y - 1];
        }

        ROOM[bottom][1] = 0;
    }
}

// strategy
// 10 - 확산: 2, 남은: 4 + 6
// 7 - 확산: 1, 남은: 5 + 6
// 30 - 확산: 6, 남은: 12 + 2 + 1 = 15
// 1. 확산. 동시에
// 상하좌우
// dust { spread, left }
// 2. 공기청정기
// 위: 반시계 | 아래: 시계
// 18 16

