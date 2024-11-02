package baekjoon.backtracking;

/*
1. 아이디어
- 수열 (순서 O)
- 수열 오름차순
- 정렬했을 때 다음 인덱스부터 고르기
- 시작점 있어야함
2. 시간복잡도
3. 자료구조
- 탐색: int[]
- 정답: int[]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p15663 {

    private static int N;
    private static int M;
    private static int[] S;
    private static int[] answer;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        S = new int[N];
        answer = new int[M];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(S);

        recur(0, 0);
        System.out.print(sb);
    }

    private static void recur(int start, int depth) {
        if (depth == M) {
            for (int a : answer) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            answer[depth] = S[i];
            recur(i + 1, depth + 1);
        }
    }
}
