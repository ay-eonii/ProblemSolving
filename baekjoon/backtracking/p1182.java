package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.아이디어
- 부분수열 중 원소의 합이 S => **연속이 아님..**
- 해당 경우의 수
if depth = N return
sum+=j
check(sum)
recur j 포함
recur j 미포함

2.시간복잡도
- 방향이 정해진 백트래킹

3.자료구조
- 탐색 그래프: int[]
 */

public class p1182 {

    private static int N;
    private static int S;
    private static int COUNT = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);

        arr = new int[N];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        recur(0, 0);

        System.out.print(COUNT);
    }

    private static void recur(int depth, int sum) {
        if (depth == N) {
            return;
        }

        if (sum + arr[depth] == S) {
            COUNT++;
        }
        recur(depth + 1, sum + arr[depth]);
        recur(depth + 1, sum);
    }
}
