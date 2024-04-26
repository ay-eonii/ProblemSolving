/* problem
M명의 조카가 있고 N개의 과자가 있을 때, 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 구하라.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        int[] cookies = new int[n];
        for (int i = 0; i < n; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
            sum += cookies[i];
        }
        if (sum < m) {
            System.out.println(0);
            return;
        }

        Arrays.sort(cookies);
        long min = 1;
        long max = cookies[n - 1];

        long answer = 0;
        while (min <= max) {
            int count = 0;
            long mid = (min + max) / 2;
            for (int cookie : cookies) {
                if (cookie >= mid) {
                    count += (int) (cookie / mid);
                }
            }

            if (count < m) {
                max = mid - 1;
            } else {
                answer = mid;
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }
}

// strategy
// 이분탐색 대상 : 막대과자 길이
// 최소: 1
// 최대: 가장 긴 막대과자 길이
// if : cookies[i] >= mid
//      while (cookies[i] / mid >= 1)
//          count++
// if : count < m -> 더 작게 나누기
//      max = mid + 1
// else min = mid - 1

// 모든 조카에게 같은 길이의 막대과자를 나눠줄 수 없는 경우
// 길이 1로도 안 됨
// -> 모든 과자길이 합 < 조카 수
// -> return 0
