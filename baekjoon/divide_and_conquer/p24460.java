package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p24460 {

    private static final List<Integer> ANSWERS = new ArrayList<>();
    private static int[][] CHAIRS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        if (n == 1) {
            st = new StringTokenizer(br.readLine());
            System.out.println(st.nextToken());
            return;
        }

        CHAIRS = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                CHAIRS[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = recur(n, 0, 0);
        System.out.println(answer);
    }

    private static int recur(int size, int row, int col) {
        if (size == 2) {
            int[] area = {
                    CHAIRS[row][col],
                    CHAIRS[row + 1][col],
                    CHAIRS[row][col + 1],
                    CHAIRS[row + 1][col + 1]
            };
            Arrays.sort(area);
            return area[1];
        }

        int newSize = size / 2;

        int first = recur(newSize, row, col);
        int second = recur(newSize, row + newSize, col);
        int third = recur(newSize, row, col + newSize);
        int fourth = recur(newSize, row + newSize, col + newSize);

        int[] area = {first, second, third, fourth};
        Arrays.sort(area);
        return area[1];
    }
}

// strategy
// 각 구역에서 추첨번호가 두번째로 작은 사람
// recur(size, 0, 0)
// newSize = size / 2
// 각 사분별로 +newSize
// recur(newSize, row + newSize, col + newSize)
// ...
// if (size == 2) ? 4 개 중에서 두번째로 작은 수 반환
// 재귀 종료 -> 두번째로 작은 수
