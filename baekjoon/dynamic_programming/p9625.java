package baekjoon.dynamic_programming;

/*
1. 아이디어
- dp
2. 시간복잡도
3. 자료구조
- int[] a
- int[] b
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        if (K == 1) {
            System.out.println(0 + " " + 1);
            return;
        }
        int[] a = new int[K + 1];
        int[] b = new int[K + 1];

        a[1] = 0;
        a[2] = 1;

        b[1] = 1;
        b[2] = 1;

        for (int i = 3; i < K + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        System.out.println(a[K] + " " + b[K]);
    }
}
