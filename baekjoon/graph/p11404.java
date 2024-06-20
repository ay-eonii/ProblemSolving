package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] city = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) { // 출발지
            for (int j = 1; j <= n; j++) { // 도착지
                if (i == j) {
                    city[i][j] = 0;
                } else {
                    city[i][j] = 100_000 * 100 + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            city[from][to] = Math.min(city[from][to], cost);
        }

        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발지
                for (int j = 1; j <= n; j++) { // 도착지
                    city[i][j] = Math.min(city[i][k] + city[k][j], city[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (city[i][j] == 100_000 * 100 + 1) {
                    sb.append("0 ");
                } else {
                    sb.append(city[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

// strategy
// 가중치 있는 그래프
//0 2 3 2 10
//0 0 0 2 0
//8 0 0 2 10
//0 0 0 0 3
//7 4 0 0 0
