package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int min = 1;
        int max = k;
        int answer = 0;
        while (min <= max) {
            int mid = (min + max) / 2;

            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                count += Math.min(mid / i, n); // 각 행에서 n보다 작은 원소 개수
                // 𝑥 보다 작은 원소의 개수는 최대 N개를 넘지 못한다.
            }

            if (count < k) {
                min = mid + 1;
            } else {
                answer = mid;
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

// strategy
// 이분탐색 대상 : 원소값
// 비교 기준 : 해당 원소값보다 작은 원소 수
