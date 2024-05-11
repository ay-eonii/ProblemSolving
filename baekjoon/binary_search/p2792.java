/* problem
원장 선생님은 모든 보석을 N명의 학생들에게 나누어 주려고 한다. 이때, 보석을 받지 못하는 학생이 있어도 된다.
하지만, 학생은 항상 같은 색상의 보석만 가져간다. 질투심은 가장 많은 보석을 가져간 학생이 가지고 있는 보석의 개수이다.
상자 안의 보석 정보와 학생의 수가 주어졌을 때, 질투심이 최소가 되게 보석을 나누어주는 방법을 알아내는 프로그램을 작성하시오.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]); // 아이들 수
        int m = Integer.parseInt(inputs[1]); // 색상의 수

        int[] jewelries = new int[m];
        for (int i = 0; i < m; i++) {
            jewelries[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries);

        int min = 1;
        int max = jewelries[m - 1]; // 가장 많은 색의 구슬 수
        int answer = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            for (int jewelry : jewelries) {
                sum += jewelry / mid;
                if (jewelry % mid != 0) {
                    sum++;
                }
            }

            if (sum > n) { // 나눠준 학생이 너무 많음
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
// 같은 색 보석끼리만
// 색상은 아이들 수보다 작거나 같다
// 1 <= 아이들수 <= 1,000,000,000
// 1 <= 색상 수 <= 300,000
// 이분탐색 대상 : 질투심(가장 많이 나누어준 보석 수)
// 일단 나눠주기 -> 나눠준 보석 개수 비교하기
// min = 1, max = 가장 많은 색의 구슬 수
// mid = (min + max) / 2
// 나눠준 학생 = sum(arr[i] / mid) -> 1 + 0
// if (sum > n) ? 나눠준 학생이 너무 많음 -> 더 많이씩(질투) 나눠주기
// min = mid + 1
// if (sum < n) ? 나눠준 학생이 너무 적음 -> 더 조금씩 나눠주기
// max = mid - 1
// 학생을 넘어서는 안됨 -> if (sum <= n)
