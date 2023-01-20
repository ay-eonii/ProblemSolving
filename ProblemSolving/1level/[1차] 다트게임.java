class Solution {

  public int solution(String dartResult) {
    double[] answerArr = new double[3];
    int index = 0;
    int answer = 0;

    String[] dartResultArr = dartResult.split("");
    for (String str : dartResultArr) {
      try {
        answerArr[index] = Integer.parseInt(str);
        index++;
      } catch (NumberFormatException e) {
        switch (str) {
          case "S":
            break;
          case "D":
            answerArr[index - 1] = Math.pow(answerArr[index - 1], 2);
            break;
          case "T":
            answerArr[index - 1] = Math.pow(answerArr[index - 1], 3);
            break;
          case "*":
            answerArr[index - 1] *= 2;
            if (index > 1) {
              answerArr[index - 2] *= 2;
            }
            break;
          case "#":
            answerArr[index - 1] *= -1;
            if (index > 1) {
              answerArr[index - 2] *= -1;
            }
            break;
        }
      }
      System.out.println("str: " + str);
      for (double i : answerArr) {
        System.out.println("answerArr: " + i);
      }
    }
    for (double i : answerArr) {
      answer += i;
    }
    return answer;
  }
}
