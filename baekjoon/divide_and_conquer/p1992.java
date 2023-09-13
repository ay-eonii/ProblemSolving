package baekjoon.divide_and_conquer;

import java.io.*;

public class p1992 {

    private static char[][] video;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        video = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = input.charAt(j);
            }
        }

        quadTree(n, 0, 0);

        bw.flush();
        bw.close();
    }

    private static void quadTree(int size, int row, int col) throws IOException {
        if (checkColor(size, row, col)) {
            bw.append(video[row][col]);
            return;
        }

        int newSize = size / 2;

        bw.append("(");
        quadTree(newSize, row, col);
        quadTree(newSize, row, col + newSize);
        quadTree(newSize, row + newSize, col);
        quadTree(newSize, row + newSize, col + newSize);
        bw.append(")");
    }

    private static boolean checkColor(int size, int row, int col) {
        int color = video[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (video[i][j] != color) return false;
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
5. 순서는 왼위 오위 왼밑 오밑
6. N -> 괄호 0, N/2 -> 괄호 1, N/4 -> 괄호 2 ...
6-1. 괄호는 재귀할때마다 추가
 *  */
