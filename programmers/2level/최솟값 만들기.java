/* problem
 * 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
 * 배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] A, int[] B) {
        List<Integer> bList = new ArrayList<>();
        for (int i : B) {
            bList.add(i);
        }

        Arrays.sort(A);
        bList.sort(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * bList.get(i);
        }

        return sum;
    }
}

// strategy
// 오름차순 * 내림차순