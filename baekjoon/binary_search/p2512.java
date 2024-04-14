/* problem
국가 예산은 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정한다.
    1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
    2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.
       상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
여러 지방의 예산요청과 국가예산의 총액이 주어졌을 때, 위의 조건을 모두 만족하도록 예산을 배정하는 프로그램을 작성하시오.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budgets = new int[n];
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(budgets);

        int min = 0;
        int max = budgets[n - 1] + 1;
        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }
            if (m < sum) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}

// strategy
// min = 0, max = 최대값 + 1
// mid = (min + max) / 2
// 각 예산과 mid 중 작은 거 합
// m 보다 크면 상한값 줄이기
// 그 외에는 min = mid + 1
