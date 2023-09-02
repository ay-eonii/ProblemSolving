package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2580 {

    private static final int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
    }

    private static void recur(int row, int col) {
        if (col == 9) {
            recur(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkRow(col, i) && checkCol(row, i) && checkSquare(row, col, i)) {
                    sudoku[row][col] = i;
                    recur(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }

        recur(row, col + 1);
    }

    private static boolean checkRow(int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int row, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSquare(int row, int col, int num) {
        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;
        for (int x = setRow; x < setRow + 3; x++) {
            for (int y = setCol; y < setCol + 3; y++) {
                if (sudoku[x][y] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}

/*
 * 1. 행 비교
 * 2. 열 비교
 * 3. 3x3 비교 : 0-2, 3-5, 6-9
 * 4. 0이 없을때까지
 * */
