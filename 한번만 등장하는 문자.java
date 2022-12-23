import java.util.Arrays;

class Solution {

  public String solution(String s) {
    String[] sArray = s.split("");
    Arrays.sort(sArray);

    String answer = "";
    for (String str : sArray) {
      if (s.length() - s.replace(str, "").length() == 1) {
        answer += str;
      }
    }
    return answer;
  }
}
