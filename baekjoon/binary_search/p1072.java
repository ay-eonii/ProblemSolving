package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1072 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        long x = Long.parseLong(inputs[0]);
        long y = Long.parseLong(inputs[1]);

        long rate = y * 100 / x;

        if (rate == 100 || rate == 99) {
            System.out.println(-1);
            return;
        }
        long start = 1;
        long end = (int) x;

        while (start < end) {
            long mid = (start + end) / 2;

            long tempX = x + mid;
            long tempY = y + mid;

            long changeRate = tempY * 100 / tempX;
            if (changeRate > rate) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(end);
    }
}

// strategy
// 승률(Z): 이긴 게임(Y) / 게임 횟수(X) * 100
// Z가 변한다 -> Z + 1 이 된다
// Z + 1 = (Y + n) / (X + n) * 100
// n < 1 ? return -1
// Z + 1 이상을 만족하는 최소 n 구하기
