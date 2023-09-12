package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2630 {

    private static int[][] paper;
    private static int white;
    private static int blue;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void cut(int size, int row, int col) {
        if (checkColor(size, row, col)) {
            if (paper[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        cut(newSize, row, col);
        cut(newSize, row, col + newSize);
        cut(newSize, row + newSize, col);
        cut(newSize, row + newSize, col + newSize);
    }

    private static boolean checkColor(int size, int row, int col) {
        int color = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
1. 정사각형 N/2로 나누기
2. 재귀(start)
3. 내부가 모두 동일한 색일때까지
4. 또는 사이즈가 1일때까지
0~3 4~7
0~1 2~3 4~5 6~7
 *  */
