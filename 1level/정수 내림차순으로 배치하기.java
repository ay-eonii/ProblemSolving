import java.util.Arrays;
import java.util.Collections;

class Solution {

  public long solution(long n) {
    String[] str = Long.toString(n).split("");
    Arrays.sort(str, Collections.reverseOrder());
    String newN = "";
    for (String s : str) {
      newN += s;
    }
    long answer = Long.parseLong(newN);
    return answer;
  }
}
