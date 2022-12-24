class Solution {

  public String solution(String bin1, String bin2) {
    String[] binStr1 = bin1.split("");
    String[] binStr2 = bin2.split("");
    int binInt1 = 0;
    int binInt2 = 0;
    for (int i = 0; i < binStr1.length; i++) {
      binInt1 +=
        Integer.valueOf(binStr1[i]) * Math.pow(2, binStr1.length - i - 1);
    }
    for (int i = 0; i < binStr2.length; i++) {
      binInt2 +=
        Integer.valueOf(binStr2[i]) * Math.pow(2, binStr2.length - i - 1);
    }

    int sum = binInt1 + binInt2;
    int p = 10;
    while (sum / Math.pow(2, p) < 1) {
      p--;
    }

    String answer = "";
    for (p = p + 1; p > 0; p--) {
      if (sum / Math.pow(2, p - 1) >= 1) {
        answer += "1";
      } else {
        answer += "0";
      }
      sum %= Math.pow(2, p - 1);
    }

    return (answer.equals("")) ? "0" : answer;
  }
}
