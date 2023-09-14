package baekjoon.divide_and_conquer;

import java.io.*;
import java.util.StringTokenizer;

public class p1780 {

    private static final int[] answers = new int[3];
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nona(N, 0, 0);

        for (int answer : answers) {
            bw.append(String.valueOf(answer)).append("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void nona(int size, int row, int col) {
        if (isPossible(size, row, col)) {
            int number = paper[row][col];
            answers[number + 1]++;
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nona(newSize, row + newSize * i, col + newSize * j);
            }
        }
    }

    private static boolean isPossible(int size, int row, int col) {
        int number = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (number != paper[i][j]) return false;
            }
        }

        return true;
    }
}

/*
1. 재귀 종료 조건: 종이 전부 같은 숫자일때
2. 재귀 범위: 왼위, 왼중, 왼오, 중왼, 중중, 중오, 왼밑, 중밑, 오밑
 *  */
