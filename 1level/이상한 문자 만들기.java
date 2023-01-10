public class Solution {

  public String solution(String s) {
    String answer = "";
    String sArr[] = s.split("");
    int index = 0;

    for (String str : sArr) {
      if (str.equals(" ")) {
        index = 0;
        answer += str;
        continue;
      }
      answer += index % 2 == 0 ? str.toUpperCase() : str.toLowerCase();
      index++;
    }
    return answer;
  }
}
