package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10819 {

    private static int N;
    private static int[] arr;
    private static boolean[] visited;

    private static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        recur(new int[N], 0);

        System.out.println(MAX);
    }

    private static void recur(int[] order, int count) {
        if (count == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs((order[i] - order[i + 1]));
            }
            MAX = Math.max(sum, MAX);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[count] = arr[i];
                recur(order, count + 1);
                visited[i] = false;
                order[count] = 0;
            }
        }
    }
}

// strategy
// |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
// 순서 바꿔서 최댓값 구하기
// 최악 : 8!
// 브루트포스
// 재귀
