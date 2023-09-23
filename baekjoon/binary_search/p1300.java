package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int start = 1;
        int end = K;

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int i = 1; i < N + 1; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}

