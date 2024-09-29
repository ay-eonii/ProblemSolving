package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p25916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int[] holes = new int[N];
        for (int i = 0; i < N; i++) {
            holes[i] = Integer.parseInt(inputs[i]);
        }

        int left = 0;
        int sum = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            sum += holes[i];
            while (sum > M) {
                sum -= holes[left++];
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}

// strategy
// 정렬안됨
// 누적합
