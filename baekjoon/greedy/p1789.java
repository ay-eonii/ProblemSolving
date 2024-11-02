package baekjoon.greedy;

/*
1. 아이디어
- 가장 작은 수부터 더하기
- 그리디
2. 시간복잡도
- 2초
3. 자료구조
- N:long
- S:long
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long i = 1;
        while (S >= i) {
            S -= i;
            i++;
        }
        System.out.print(i - 1);
    }
}
