import java.util.Arrays;

class Solution {

  public int[] solution(String my_string) {
    String[] my_array = my_string.split("");
    Arrays.sort(my_array);

    String answer = "";

    //배열 사이즈 알아내기
    for (String s : my_array) {
      char num = s.charAt(0);
      if (Character.isDigit(num)) {
        answer += s;
      }
    }
    //숫자 추출
    String[] answerArray = answer.split("");
    int[] answerInt = new int[answer.length()];
    for (int i = 0; i < answer.length(); i++) {
      answerInt[i] = Integer.valueOf(answerArray[i]);
    }
    return answerInt;
  }
}
