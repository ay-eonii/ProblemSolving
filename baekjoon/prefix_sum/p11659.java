package baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class p11659 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        numbers = new int[N + 1];
        numbers[0] = 0;
        for (int i = 1; i <= N; i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(numbers[end] - numbers[start - 1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

/*
 * 1. 배열에 누적합 저장
 * 2. 포함안되는 값 빼주기
 *  */
