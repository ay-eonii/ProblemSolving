package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2447 {

    private static String[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        stars = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stars[i][j] = " ";
            }
        }

        setStar(0, 0, N);
        for (String[] star : stars) {
            for (String s : star) {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void setStar(int startX, int startY, int N) {
        if (N == 1) {
            stars[startX][startY] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    setStar(startX + i * (N / 3), startY + j * (N / 3), N / 3);
                }
            }
        }

    }
}
