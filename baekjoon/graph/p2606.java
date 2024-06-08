package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2606 {
    private static boolean[][] NETWORKS;
    private static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());
        VISITED = new boolean[computerCount + 1];

        NETWORKS = new boolean[computerCount + 1][computerCount + 1];
        for (int i = 0; i < edgeCount; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            NETWORKS[a][b] = NETWORKS[b][a] = true;
        }

        dfs(1);

        int answer = 0;
        for (int i = 2; i < VISITED.length; i++) {
            if (VISITED[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int start) {
        if (VISITED[start]) {
            return;
        }

        VISITED[start] = true;
        for (int i = 1; i < NETWORKS.length; i++) {
            if (NETWORKS[start][i]) {
                dfs(i);
            }
        }
    }
}

// strategy
// dfs
