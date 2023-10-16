package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10830 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        long B = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] answer = pow(A, B);


        StringBuilder sb = new StringBuilder();
        for (int[] i : answer) {
            for (int j : i) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] pow(int[][] A, long size) {
        if (size == 1L) {
            return A;
        }

        int[][] divided = pow(A, size / 2);
        divided = multiply(divided, divided);

        if (size % 2 == 1L) {
            divided = multiply(divided, A);
        }

        return divided;
    }

    private static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] divided = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    divided[i][j] += o1[i][k] * o2[k][j];
                    divided[i][j] %= 1000;
                }
            }
        }
        return divided;
    }
}

// (A*A*A*A) % 1000
// -> ((A*A) % 1000 * (A*A) % 1000) % 1000