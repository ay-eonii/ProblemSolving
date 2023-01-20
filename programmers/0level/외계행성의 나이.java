//내 풀이
class Solution {

  public String solution(int age) {
    String answer = Integer.toString(age);
    answer = answer.replace("0", "a");
    answer = answer.replace("1", "b");
    answer = answer.replace("2", "c");
    answer = answer.replace("3", "d");
    answer = answer.replace("4", "e");
    answer = answer.replace("5", "f");
    answer = answer.replace("6", "g");
    answer = answer.replace("7", "h");
    answer = answer.replace("8", "i");
    answer = answer.replace("9", "j");
    return answer;
  }
}

//다른 사람 풀이
class Solution {

  public String solution(int age) {
    String answer = "";
    char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };

    while (age >= 1) {
      answer = alpha[age % 10] + "" + answer;
      age /= 10;
    }
    return answer;
  }
}
