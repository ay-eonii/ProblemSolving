package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1. 아이디어
- N개의 자연수 중에서 M개를 고른 '수열' -> 순서 상관있음
- 사전 순 출력 -> 정렬하고 시작
- 재귀에서 방문여부 확인
2. 시간복잡도
- N^N
3. 자료구조
- 탐색: int[N]
- 정답: int[M]
 */

public class p15654 {

    private static final StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int[] S;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        S = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(S);

        recur(0);
        System.out.print(sb);
    }

    private static void recur(int depth) {
        if (depth == M) {
            for (int a : answer) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < S.length; i++) {
            if (visited[i]) {
                continue;
            }

            answer[depth] = S[i];
            visited[i] = true;
            recur(depth + 1);
            visited[i] = false;
        }
    }
}

