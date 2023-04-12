package baekjoon.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11050 {
    private static boolean[] visited;
    private static int k;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        visited = new boolean[n];

        combination(0, 0);
        System.out.println(cnt);
    }

    private static void combination(int r, int start) {
        if (r == k) {
            cnt++;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(r + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

