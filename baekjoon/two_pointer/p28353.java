package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p28353 {

    private static int N;
    private static int K;
    private static int[] cats;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        cats = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            cats[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(cats);

        int happiness = 0;

        int start = 0;
        int end = N - 1;
        while (start < end) {
            int sum = cats[start] + cats[end];
            if (sum <= K) {
                happiness++;
                start++;
                end--;
                continue;
            }
            end--;
        }

        System.out.println(happiness);
    }
}

// strategy
// 2개를 조합해 최대를 넘지 않는 최대 경우의 수
// 정렬
// 투포인터
