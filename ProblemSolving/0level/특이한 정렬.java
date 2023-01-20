import java.util.*;

class Solution {

  public int[] solution(int[] numlist, int n) {
    List<Integer> list = new ArrayList<>();
    for (int i : numlist) {
      list.add(Math.abs(i - n));
    }
    Collections.sort(list);
    Arrays.sort(numlist);

    int count;
    int[] answer = new int[numlist.length];

    for (int i : numlist) {
      count = Collections.frequency(list, Math.abs(i - n));
      if (i < n && count > 1) {
        answer[list.indexOf(Math.abs(i - n)) + 1] = i;
      } else {
        answer[list.indexOf(Math.abs(i - n))] = i;
      }
    }
    return answer;
  }
}
