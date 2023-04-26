package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1018 {

    static String[][] blackFirst = {
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
    };
    static String[][] whiteFirst = {
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        String[][] chess = new String[N][M];
        for (int i = 0; i < N; i++) {
            chess[i] = br.readLine().split("");
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cntB = getCnt(i, j, chess, blackFirst);
                int cntW = getCnt(i, j, chess, whiteFirst);
                min = Math.min(min, Math.min(cntB, cntW));
            }
        }
        System.out.println(min);
    }

    private static int getCnt(int i, int j, String[][] chess, String[][] chess1) {
        int cnt = 0;
        for (int n = i; n < i + 8; n++) {
            for (int m = j; m < j + 8; m++) {
                if (!chess[n][m].equals(chess1[n - i][m - j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


/*
 * 1. 체스판 시작 위치 정하기
 * 1-1. 0,0 부터 시작해서
 * 1-2. N - 8, M - 8 까지
 * */