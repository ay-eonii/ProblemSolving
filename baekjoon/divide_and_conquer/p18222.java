package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p18222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        long n = 1;
        while (n < k) {
            n *= 2;
        }

        int answer = recur(n, k);
        System.out.println(answer);
    }

    private static int recur(long order, long index) {
        if (order == 1) {
            return (index == 1) ? 0 : 1;
        }

        long newOrder = order / 2;
        if (index <= newOrder) {
            return recur(newOrder, index);
        } else {
            int recur = recur(newOrder, index - newOrder);
            return (recur == 1) ? 0 : 1;
        }
    }
}

// strategy
// 1번째 : 0 -> 2^0
// 2번째 : 01 -> 2^1
// 3번째 : 0110 -> 2^2
// 4번째 : 01101001 -> 2^3
// 4번째 : 0110100110010110 -> 2^4
// N번째 -> 2^(N-1)
// k 번째 == k / 2^(N-2) 번째의 역
