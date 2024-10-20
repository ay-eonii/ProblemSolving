package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1026 {

    private static int N;
    private static Integer[] A;
    private static Integer[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new Integer[N];
        B = new Integer[N];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            A[j] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            B[j] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (A[i] * B[i]);
        }

        System.out.println(sum);
    }
}

// strategy
// S = A[0] × B[0] + ... + A[N-1] × B[N-1]
// S의 값을 가장 작게 만들기 위해 A의 수를 재배열
// B는 재배열하지 않음
// 배열의 길이는 50 이하 -> 50!
// 브루트포스 -> 시간초과
// 그리디
// A -> 오름차순
// B -> 내림차순
