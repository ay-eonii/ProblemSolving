/*
산성 용액과 알칼리성 용액의 특성값이 주어졌을 때,
이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
 */

package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st ew StringTokenizer(br.readLine());
        int[] solids = new int[n];
        for (int i = 0; i < n; i++) {
            solids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solids);
        int min = 0;
        int max = n - 1;
        int[] answers = new int[]{solids[min], solids[max]};
        long diff = Long.MAX_VALUE;
        while (min < max) {
            long sum = solids[min] + solids[max];

            long absDiff = Math.abs(sum);
            if (absDiff < diff) {
                diff = absDiff;
                answers[0] = solids[min];
                answers[1] = solids[max];
            }

            if (sum > 0) {
                max--;
            } else if (sum < 0) {
                min++;
            } else {
                break;
            }
        }

        System.out.println(answers[0] + " " + answers[1]);
    }
}

// strategy
// 1 <= acid <= 1,000,000,000
// 1,000,000,000 <= alkali <= -1
// 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액 만들기

// 특성값 오름차순 정렬
// -99 -2 -1 4 98
// 이분탐색 대상: 특성값 배열 인덱스
// min = 0
// max = n - 1
// while (min <= max)
// if sum > 0 ? 산성 -> max--
// if sum < 0 ? 염기성 -> min++
// if sum == 0 ? return
