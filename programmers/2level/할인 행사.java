import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int answer = 0;
        for (int i = 0; i < discount.length - 10 + 1; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                if (!wantMap.containsKey(discount[j])) break;

                discountMap.computeIfPresent(discount[j], (s, integer) -> integer + 1);
                discountMap.putIfAbsent(discount[j], 1);
            }

            boolean flag = true;
            for (String w : wantMap.keySet()) {
                if (wantMap.get(w) != discountMap.get(w)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}