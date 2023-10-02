package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2740 {

    private static int[][] A;
    private static int[][] B;
    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        initMatrix(A);

        st = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        B = new int[M][K];
        initMatrix(B);


        int[][] answers = new int[N][K];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < K; col++) {
                answers[row][col] = multi(M, row, col);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] answer : answers) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void initMatrix(int[][] arr) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int multi(int M, int n, int k) {
        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += A[n][i] * B[i][k];
        }
        return sum;
    }
}

/*
 * 행렬의 곱셈 => N,M x M,K -> N,K
 * 좌 행(0) * 우 열(0) -> 0,0
 * 좌 행(1) * 우 열(1) -> 1,1
 * 분할정복? 행, 열로 분할
 * */
