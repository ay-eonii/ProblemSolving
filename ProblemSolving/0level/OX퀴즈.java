class Solution {

  public String[] solution(String[] quiz) {
    String[] answer = new String[quiz.length];
    int index = 0;

    for (String str : quiz) {
      String[] e = str.split(" ");
      int a;
      if (e[1].equals("+")) {
        a = Integer.valueOf(e[0]) + Integer.valueOf(e[2]);
      } else {
        a = Integer.valueOf(e[0]) - Integer.valueOf(e[2]);
      }

      answer[index] = (a == Integer.valueOf(e[4])) ? "O" : "X";
      index++;
    }
    return answer;
  }
}
