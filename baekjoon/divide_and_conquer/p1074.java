/*
크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다.
N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
 */

package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1074 {

    private static int N;
    private static int R;
    private static int C;
    private static int SUM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        recur(size, 0, 0);

        System.out.println(SUM);
    }

    private static void recur(int size, int row, int col) {
        if (size == 1) {
            return;
        }

        int newSize = size / 2;

        if (row + newSize > R && col + newSize > C) { // 1사분면
            recur(newSize, row, col);
        }
        if (row + newSize > R && col + newSize <= C) { // 2사분면
            SUM += (newSize * newSize);
            recur(newSize, row, col + newSize);
        }
        if (row + newSize <= R && col + newSize > C) { //3사분면
            SUM += (newSize * newSize) * 2;
            recur(newSize, row + newSize, col);
        }
        if (row + newSize <= R && col + newSize <= C) { //4사분면
            SUM += (newSize * newSize) * 3;
            recur(newSize, row + newSize, col + newSize);
        }
    }
}

// strategy
// 크기가 2^N × 2^N인 2차원 배열을 Z모양으로 탐색
// 사이즈가 1일때까지 재귀
//
// recur(8, 0, 0)
// recur(4, 0, 0)
// recur(2, 2, 0)
// newSize = 2 / 2
// if (newSize <= r) ? row += newSize
// if (newSize <= c) ? col += newSize
// recur(1, 3, 1)
//
