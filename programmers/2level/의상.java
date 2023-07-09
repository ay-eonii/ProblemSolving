/* problem
코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> closet = new HashMap<>();
        for (String[] cloth : clothes) {
            closet.putIfAbsent(cloth[1], 1);
            closet.computeIfPresent(cloth[1], (k, v) -> v + 1);
        }

        int answer = 1;
        for (Integer i : closet.values()) {
            answer *= i;
        }

        return answer - 1;
    }
}

/* strategy
1. 경우의 수 -> (종류별 개수 + 1)의 곱 - 1
*/