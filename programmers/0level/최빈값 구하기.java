import java.util.*;

class Solution {

  public int solution(int[] array) {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int i : array) {
      list.add(i);
      set.add(i);
    }

    int answer = 0;
    int count = 0;
    for (int i : set) {
      if (Collections.frequency(list, i) > count) {
        count = Collections.frequency(list, i);
        answer = i;
      } else if (Collections.frequency(list, i) == count) answer = -1;
    }
    return answer;
  }
}
