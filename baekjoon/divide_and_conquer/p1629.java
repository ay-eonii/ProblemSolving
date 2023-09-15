package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1629 {

    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(recur(a, b));
    }

    private static long recur(int a, int b) {
        if (b == 1) {
            return a % c;
        }

        long temp = recur(a, b / 2);

        if (b % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;
    }
}

/*
* 지수법칙, 모듈러 성질 *
1. a, b, c -> int 가능
2. a * a 는 long
3. 절반으로 나누어진 지수 중 하나만 구하면 됨. (홀수인 경우 지수가 1이 아닌
 */
