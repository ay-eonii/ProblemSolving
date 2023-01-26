/* problem
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 
만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!list.contains(Integer.valueOf(numbers[i] + numbers[j]))) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}

/*
 * strategy
 * 1. numbers 0(i)부터 순회
 * 2. numbers i + i(j)부터 순회
 * 3. if (!answer.contains(1. + 2.))
 * 4. sort
 * 
 * valueOf: return Integer
 * parseInt: return int
 */
