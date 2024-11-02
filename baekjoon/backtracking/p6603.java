package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 아이디어
- 정렬
- 연속이아님
- 순서가 있는 백트래킹
- 선택/미선택 재귀
- 재귀에서 숫자가 6일 경우 print 후 return
- 재귀에서 depth가 K 인경우 return
2. 시간복잡도
3. 자료구조
- 탐색대상: int[]
 */

public class p6603 {

    private static final int[] lotto = new int[6];
    private static int K;
    private static int[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            String[] inputs = br.readLine().split(" ");
            if ("0".equals(inputs[0])) {
                break;
            }

            K = Integer.parseInt(inputs[0]);
            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(inputs[i + 1]);
            }

            recur(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recur(int start, int depth) {
        if (depth == 6) {
            for (int l : lotto) {
                sb.append(l + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            lotto[depth] = arr[i];
            recur(i + 1, depth + 1);
        }
    }
}
