class Solution {

  public int solution(String dartResult) {
    double[] answerArr = new double[3];
    String num = "0123456789";
    int index = 0;
    int answer = 0;

    String[] dartResultArr = dartResult.split("");
    for (int i = 0; i < dartResultArr.length; i++) {
      if (num.contains(dartResultArr[i])) {
        if (
          i > 0 &&
          dartResultArr[i].equals("0") &&
          dartResultArr[i - 1].equals("1")
        ) {
          answerArr[--index] = 10;
        } else {
          answerArr[index] = Integer.parseInt(dartResultArr[i]);
        }
        index++;
      } else {
        switch (dartResultArr[i]) {
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
            break;
        }
      }
    }
    for (double i : answerArr) {
      answer += i;
    }
    return answer;
  }
}
