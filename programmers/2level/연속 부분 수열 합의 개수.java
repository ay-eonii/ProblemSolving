/* problem
 * 원형 수열의 모든 원소 elements가 순서대로 주어질 때, 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        int[] arr = new int[len * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i % elements.length];
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}

/* strategy
1. return set.size
2. int[elements.length * 2 - 1]
3. 원소 1개부터 원소 elements.length개 까지 -> for (i = 1; i < elements.length; i++)
4. for (j = 0; j < elements.length;) : 시작점
5. for (k = j; k < j + i; k++) : j부터 i개 더하기
7 9 1 1 4 7 9 1 1
*/