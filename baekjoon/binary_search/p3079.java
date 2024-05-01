/*
입국심사대는 총 N개가 있다. 각 입국심사관이 심사를 하는데 걸리는 시간은 사람마다 모두 다르다.
k번 심사대에 앉아있는 심사관이 한 명을 심사를 하는데 드는 시간은 Tk이다.
상근이와 친구들이 심사를 받는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] checkpoints = new int[n];
        for (int i = 0; i < n; i++) {
            checkpoints[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(checkpoints);
        long min = checkpoints[0];
        long max = (long) checkpoints[0] * m;

        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long checkPeople = 0;
            for (int checkpoint : checkpoints) {
                checkPeople += mid / checkpoint;
            }

            if (checkPeople < m) {
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
// 입국심사대 개수 : 1 ≤ N ≤ 100,000
// 입국심사대 소요 시간: 1 ≤ Tk ≤ 1,000,000,000
// 친구들 수 : 1 ≤ M ≤ 1,000,000,000

// 이분탐색 대상: 총 심사 시간
// T 오름차순 정렬
// max : 가장 적게 걸리는 심사시간 * M
// min : 가장 적게 걸리는 심사시간

// while (min <= max)
//      mid = (min + max) / 2
//      sum(mid / k[i])
//      if (sum < m) -> 다 심사 못받음 -> 시간 늘리기
//          : min = mid + 1
//      else -> 다 심사 받음 | 심사 받고도 시간 남음
//          answer = mid
//          : max = mid - 1

// 24
// 24 / 7 + 24 / 10 = 3 + 2 < 6
// min = mid + 1
// max : 42
// min : 25
// mid :  33
// 33 / 7 + 33 /10 = 4 + 3 > 6
// max = mid - 1
// max = 32
// min = 25
// mid = 28
