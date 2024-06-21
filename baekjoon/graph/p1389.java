package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] friends = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] friend = br.readLine().split(" ");
            int a = Integer.parseInt(friend[0]);
            int b = Integer.parseInt(friend[1]);
            friends[a][b] = friends[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j && friends[i][k] >= 1 && friends[k][j] >= 1) {
                        if (friends[i][j] == 0) {
                            friends[i][j] = friends[j][i] = friends[i][k] + friends[k][j];
                        } else {
                            friends[i][j] = friends[j][i] = Math.min(friends[i][k] + friends[k][j], friends[i][j]);
                        }
                    }
                }
            }
        }

        int answer = 1;
        int min = n * n;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                count += friends[i][j];
            }
            if (min > count) {
                min = count;
                answer = i;
            }
        }

        System.out.print(answer);
    }
}

// strategy
// 케빈 베이컨 수는 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합
