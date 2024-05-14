package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5904 {

    private static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("m");
            return;
        }

        long size = 3;
        int k = 0;
        while (size < N) {
            k++;
            size = size + (k + 3) + size;
        }

        S(k, size);
    }

    private static void S(int k, long size) {
        long newSize = (size - (k + 3)) / 2;

        if (k == 0) {
            if (N == 1) {
                System.out.print("m");
            } else {
                System.out.print("o");
            }
            return;
        }

        if (N <= newSize) {
            S(k - 1, newSize);
        } else if (N <= newSize + (k + 3)) { // 중간
            if (newSize + 1 == N) {
                System.out.print("m");
            } else {
                System.out.print("o");
            }
        } else { // 끝
            N -= newSize + (k + 3);
            S(k - 1, newSize);
        }
    }
}

// strategy
// S(k) = S(k-1) + "m o.repeat(k+2)" + S(k-1)
// S(0).length = moo
// S(1).length = 10 -> (S(0) * 2) + (3 + 1)
// S(2).length = 25 -> (S(1) * 2) + (3 + 2)

// m -> 0
// m -> 0, 3, 7
// m ->
