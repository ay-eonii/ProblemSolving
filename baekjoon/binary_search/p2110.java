/* problem
C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int c = Integer.parseInt(inputs[1]);

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);
        int min = 1;
        int max = x[n - 1] - x[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;

            int count = install(x, mid);
            if (count < c) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    private static int install(int[] x, int mid) {
        int count = 1;
        int latest = 0;
        for (int i = 0; i < x.length; i++) {
            int distance = x[i] - x[latest];
            if (distance >= mid) {
                count++;
                latest = i;
            }
        }
        return count;
    }
}

// strategy
// 탐색 대상 : 공유기 사이의 거리
// 1부터 N
// upper-bound
// min = 1
// max = 제일 마지막집 - 제일 앞집 + 1
// mid = (min + max) / 2
// 현재 집과 가장 최근에 설치한 집 사이 거리가 mid 이상이면 설치
// 공유기 수가 c보다 크면 max = mid
// 아니라면 min = mid + 1
