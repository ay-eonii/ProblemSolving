package baekjoon.backtracking;

/*
1. 아이디어
- 같은 수 여러 고르기 가능 -> 방문여부 체크 불필요
- 비내림차순 -> 순열 순서X
- 출력은 사전 순 증가 순서
2. 시간복잡도
- N^N
3. 자료구조
- 탐색: int[N]
- 정답: int[M]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p15657 {

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
            recur(i, depth + 1); // 중복선택 가능
        }
    }
}
