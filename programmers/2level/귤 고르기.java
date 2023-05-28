import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }

        Collection<Integer> values = map.values();
        Object[] array = values.toArray();
        Arrays.sort(array, Collections.reverseOrder());
        int answer = 0;

        int i = 0;
        do {
            k -= (Integer) array[i];
            answer++;
            i++;
        } while (k > 0);

        return answer;
    }
}