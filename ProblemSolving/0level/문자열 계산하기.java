import java.util.Arrays;

class Solution {

  public int solution(String my_string) {
    String[] operand = my_string.split(" ");

    for (int i = 2; i < operand.length; i = i + 2) {
      if (operand[i - 1].equals("+")) {
        int temp = Integer.valueOf(operand[0]) + Integer.valueOf(operand[i]);
        operand[0] = String.valueOf(temp);
      } else {
        int temp = Integer.valueOf(operand[0]) - Integer.valueOf(operand[i]);
        operand[0] = String.valueOf(temp);
      }
    }
    return Integer.valueOf(operand[0]);
  }
}
