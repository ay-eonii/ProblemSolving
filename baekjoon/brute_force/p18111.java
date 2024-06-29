package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]); // 세로
        int m = Integer.parseInt(inputs[1]); // 가로
        int b = Integer.parseInt(inputs[2]); // 블록

        int[][] area = new int[n][m];
        int min = 256;
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, area[i][j]);
                max = Math.max(max, area[i][j]);
            }
        }

        int minTime = 500 * 500 * 256;
        int maxHeight = 0;
        for (int height = min; height <= max; height++) {
            int tempTime = 0;
            int tempB = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (area[i][j] > height) {
                        int diff = area[i][j] - height;
                        tempTime += diff * 2; // 파기
                        tempB += diff;
                    }
                    if (area[i][j] < height) {
                        int diff = height - area[i][j];
                        tempTime += diff; // 채우기
                        tempB -= diff;
                    }
                }
            }

            if (tempB < 0) {
                continue;
            }

            if (tempTime <= minTime) {
                minTime = tempTime;
                maxHeight = Math.max(maxHeight, height);
            }
        }

        System.out.print(minTime + " " + maxHeight);
    }
}

// strategy
// 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. : 2초
// 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. : 1초
// ‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 높이 구하기
// 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력하시오.

// 이분탐색?
// 탐색대상: 땅 높이

// 완전탐색이었음
