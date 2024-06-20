package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                sb.append(arr[y][x]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

// dfs
// 1인곳 탐색 -> 도착지에 연결된 경로 재귀 탐색
// (x,y) -> (y, 1)
// 0 -> 1 -> 2 -> 0
// 01 -> 12 -> 20 -> 01
