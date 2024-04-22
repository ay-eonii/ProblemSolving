/* problem
현우는 앞으로 N일 동안 자신이 사용할 금액을 계산하였고, 돈을 펑펑 쓰지 않기 위해 정확히 M번만 통장에서 돈을 빼서 쓰기로 하였다.
현우가 필요한 최소 금액 K를 계산하는 프로그램을 작성하시오.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] moneys = new int[n];
        int min = 0;
        for (int i = 0; i < n; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
            min = Integer.max(min, moneys[i]);
        }

        int max = 10_000 * 100_000;
        int answer = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int drawCount = 1;
            int left = mid;
            for (int money : moneys) {
                if (money > left) {
                    drawCount++;
                    left = mid;
                }
                left -= money;
            }

            if (drawCount > m) {
                min = mid + 1;
                answer = min;
            } else {
                answer = mid;
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

// strategy
// 이분 탐색 대상: 인출할 금액 K
// lower-bound
// min = sum / m
// max = sum
// 용돈이 모자라다면 또 빼기 -> while (money[i] > mid) ? count++; mid += mid;

// 라고 생각했지만 아니었음
// 한 번만 뺄 수 있다 -> K가 moneys[i]보다 작다면 영원히 안됨

// if (count > m) : 용돈이 작은 거 -> min = mid
// else : 용돈이 남거나 적당 -> max = mid - 1

// 10,000 * 100,000 = 1,000,000,000 -> mid : int
