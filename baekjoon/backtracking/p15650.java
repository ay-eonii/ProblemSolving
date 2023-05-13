package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15650 {
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        visited = new boolean[N];

        combi(0, M);
        System.out.println(sb);
    }

    private static void combi(int start, int M) {
        if (M == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, M - 1);
                visited[i] = false;
            }
        }
    }
}
