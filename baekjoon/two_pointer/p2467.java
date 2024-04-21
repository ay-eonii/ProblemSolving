/* problem
산성 용액과 알칼리성 용액의 특성값이 정렬된 순서로 주어졌을 때,
이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
 */

package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] solutions = new int[n];
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[]{solutions[0], solutions[n - 1]};
        int left = 0;
        int right = n - 1;
        long differentFromZero = Math.abs(solutions[0] + solutions[n - 1]);
        while (left < right) {
            long sum = solutions[left] + solutions[right];
            if (Math.abs(sum) < differentFromZero) {
                differentFromZero = Math.abs(sum);
                answer[0] = solutions[left];
                answer[1] = solutions[right];
            }
            if (sum == 0) {
                break;
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}

// strategy
// -1,000,000,000 <= 용액 특성 <= 1,000,000,000 -> int
// 합이 0과 가까운 두 용액 찾기
// 합은 long
// 이진 탐색 대상 : 용액 배열의 인덱스
// sum = 가장 알칼리성(left) + 가장 산성(right)
// 이전에 구한 0과 가장 가까운 sum 과 비교
// 이번에 구한 sum이 0과 더 가깝다면
// 해당 값들 저장

// if (sum < 0) : 알칼리성
// arr[left + 1]
// if (sum == 0) : find
// else : 산성
// arr[right - 1]

// while (left < right)