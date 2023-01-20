import java.util.ArrayList;
import java.util.List;

class Solution {

  public int[] solution(int[] lottos, int[] win_nums) {
    List<Integer> list = new ArrayList<>();
    for (int i : win_nums) {
      list.add(i);
    }

    int sameCount = 0;
    int zeroCount = 0;
    for (int lotto : lottos) {
      if (list.contains(Integer.valueOf(lotto))) {
        sameCount++;
      }
      if (lotto == 0) {
        zeroCount++;
      }
    }

    int maxRank = (sameCount == 0 && zeroCount == 0)
      ? 6
      : 7 - (sameCount + zeroCount);
    int minRank = (sameCount == 0) ? 6 : 7 - sameCount;
    return new int[] { maxRank, minRank };
  }
}
