package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temperature[i];
        }

        int max = sum;
        for (int start = 0; start < N - K; start++) {
            sum -= temperature[start];
            sum += temperature[start + K];

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}

/*
 * 1. 배열에 누적합 저장
 * 2. 이후 온도 하나씩 추가하고, 이전 온도 하나씩 빼기
 *  */
