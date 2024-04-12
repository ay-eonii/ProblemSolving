/*
각 스태프가 풍선 하나를 만드는 시간(분) Ai를 알고 있을 때, 풍선 M개를 만들기 위해서 최소 몇 분이 걸릴까?
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p15810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(arr);
        long min = 1;
        long max = (long) arr[n - 1] * m;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int a : arr) {
                sum += mid / a;
            }

            if (sum >= m) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max + 1);
    }
}

// strategy
// 1 <= 스태프 수, 풍선의 수 <= 1,000,000
// 1 <= 풍선 만든느 데 걸리는 시간 <= 1,000,000
// 이진 탐색 대상 : M 개의 풍선을 만드는 데 걸리는 최소 시간
// min = 1, max = 가장 오래걸리는 시간 * 풍선 수
// mid = (min + max) / 2 : 총 걸리는 시간
// 만든 풍선 수(S) : sum(mid/Ai)
// if (S < M) ? min = mid : max = mid - 1
