package baekjoon.dynamic_programming;

/*
1. 아이디어
- 상태: 좌석이 N개일때 앉을 수 있는 경우의 수
- a,b 중 b 가 자리잡으면 a -> a,b / b,a
- a,b,c 중 c가 자리잡으면 ab -> (a,b / b,a) + c / a,c,b
- a,b,c,d 중 d 가 자리잡으면 abc -> (a,b,c / b,a,c / a,c,b) + d / (a,b / b,a) + (d,c)
- 즉, 이전에 구한거 + 더 이전에 구한거 (ab/ba + dc)
- 이후 vip 기준으로 분리된 경우의 수 곱
- => vip 다음부터 초기화 할 필요 x. N명인 경우 인덱스로 dp 구하면 됨.
- 점화식: dp[n] = dp[n-1] + dp[n-2]
2. 시간복잡도
3. 자료구조
- int[]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] seat = new int[41];
        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        seat[0] = 1;
        seat[1] = 1;
        seat[2] = 2;

        for (int i = 3; i < N + 1; i++) {
            seat[i] = seat[i - 1] + seat[i - 2];
        }

        int answer = 1;
        int start = 0;
        for (int v : vip) {
            answer *= seat[v - 1 - start];
            start = v;
        }

        answer *= seat[N - start];

        System.out.println(answer);
    }
}
