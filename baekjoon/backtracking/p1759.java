package baekjoon.backtracking;

/*
1. 아이디어
- 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
- 알파벳 증가하는 순서
- 가능성 있는 암호들을 모두 구하는 프로그램
- 각 위치(인덱스)마다 유효한 조건 내에서 백트래킹
- 방문여부
- 재귀 종료 조건 : depth == L
- 사전식 출력 -> 주어진 알파벳 정렬
- 모음자음 구분 후 탐색 / 모두 탐색 후 필터링
2. 시간복잡도
- 최악: L = C = 15, 모음 1개, 자음 14개 -> 14! = 87,178,291,200 ??
3. 자료구조
- 탐색 = char[]
- 정답 = char[]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;

public class p1759 {

    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    private static int L;
    private static int C;
    private static char[] S;
    private static char[] answer;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        L = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        S = new char[C];
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            S[i] = inputs[i].charAt(0);
        }

        Arrays.sort(S);
        answer = new char[L];

        recur(0, 0);
        System.out.print(sb);
    }

    private static void recur(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                return;
            }
            for (char a : answer) {
                sb.append(a);
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            if (visited[i]) {
                continue;
            }
            answer[depth] = S[i];
            visited[i] = true;
            recur(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static boolean isValid() {
        int vowelCount = 0;
        for (char a : answer) {
            if (vowels.contains(a)) {
                vowelCount++;
            }
        }
        return vowelCount < 1 || (L - vowelCount) < 2;
    }
}
