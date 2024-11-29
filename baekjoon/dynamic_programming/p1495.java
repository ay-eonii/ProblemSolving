package baekjoon.dynamic_programming;

/*
1. 아이디어
- 완탐: 2^50 -> 시간초과
- dp: 상태 : N번째 곡 P볼륨 가능한지 => 2차원배열, 값 :true,false
- 최대값: 마지막 순서 중 true인 마지막 인덱스
2. 시간복잡도
3. 자료구조
- boolean[][] dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int M = Integer.parseInt(inputs[2]);

        boolean[][] canPlay = new boolean[N + 1][M + 1]; //N번째 곡, M볼륨
        canPlay[0][S] = true;
        inputs = br.readLine().split(" ");

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (!canPlay[i - 1][j]) { // 전 볼륨 아니면 패스
                    continue;
                }

                if (j + Integer.parseInt(inputs[i - 1]) <= M) {
                    canPlay[i][j + Integer.parseInt(inputs[i - 1])] = true;
                }

                if (j - Integer.parseInt(inputs[i - 1]) >= 0) {
                    canPlay[i][j - Integer.parseInt(inputs[i - 1])] = true;
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (canPlay[N][i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
