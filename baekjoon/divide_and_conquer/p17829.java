package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17829 {

    private static int[][] MATRIX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MATRIX = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                MATRIX[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = divide(n, 0, 0);
        System.out.println(answer);
    }

    private static int divide(int size, int width, int height) {
        if (size == 1) {
            return MATRIX[width][height];
        }

        int newSize = size / 2;
        int[] four = {
                divide(newSize, width, height),
                divide(newSize, width, height + newSize),
                divide(newSize, width + newSize, height),
                divide(newSize, width + newSize, height + newSize)
        };

        Arrays.sort(four);
        return four[2];
    }
}
