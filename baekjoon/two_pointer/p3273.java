/*
n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
 */

package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int answer = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                answer++;
                left++;
                right--;
                continue;
            }

            if (sum > x) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer);
    }
}

// strategy
// 정렬
// 앞 / 뒤 부터
// sum > n ? right--
// sum < n ? left++
// sum == n ? answer++
