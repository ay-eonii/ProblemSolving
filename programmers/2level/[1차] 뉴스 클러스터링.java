/* problem
두 문자열 사이의 자카드 유사도를 구하여라.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = getSubstringCount(str1);
        Map<String, Integer> map2 = getSubstringCount(str2);

        int same = getSame(map1, map2);
        int total = getTotal(map1, map2);

        if (total == 0) {
            return 65536;
        }

        double answer = (double) same / (double) total;
        return (int) (answer * 65536);
    }

    private int getSame(Map<String, Integer> map1, Map<String, Integer> map2) {
        int same = 0;
        for (String key : map1.keySet()) {
            Integer m1 = map1.get(key);
            Integer m2 = map2.getOrDefault(key, 0);
            same += Math.min(m1, m2);
        }
        return same;
    }

    private int getTotal(Map<String, Integer> map1, Map<String, Integer> map2) {
        int total = 0;
        for (String key : map1.keySet()) {
            Integer m1 = map1.get(key);
            Integer m2 = map2.getOrDefault(key, 0);
            total += Math.max(m1, m2);

            map2.remove(key);
        }

        for (Integer value : map2.values()) {
            total += value;
        }

        return total;
    }

    private Map<String, Integer> getSubstringCount(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            if (sub.matches("[a-z]{2}")) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        return map;
    }
}

/* strategy
자카드 유사도: 교집합/합집합. 합집합이 공집합인 경우 -> 1
합집합 = A + B - 교집합
중복일 경우-> 교집합은 min, 합집합은 max
1. toLowerCase를 기준
2. substring(i, i + 2)으로 두글자 자르기
2-1. for (int i = 0; i < length - 1; i++)
3. 영문 아니면 continue;
4. 영문이면 각자 set에 저장
5. 두 리스트 비교
5-1. 같으면 same++
5-2. 주의!! 교집합은 min, 합집합은 max
6. A set.lenght + B set.length - same
*/