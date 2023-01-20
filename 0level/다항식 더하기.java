class Solution {

  public String solution(String polynomial) {
    String[] polynomialArray = polynomial.split(" ");
    int x = 0;
    int n = 0;

    for (String p : polynomialArray) {
      if (p.contains("x")) {
        if (p.length() == 1) {
          x++;
        } else {
          p = p.replace("x", "");
          x += Integer.valueOf(p);
        }
      } else if (!p.contains("+")) {
        n += Integer.valueOf(p);
      }
    }
    String answer = "";

    if (x != 0) {
      if (x == 1) {
        answer = "x";
      } else {
        answer = x + "x";
      }
      if (n != 0) {
        answer = answer.concat(" + " + n);
      }
    } else {
      if (n != 0) {
        answer = Integer.toString(n);
      }
    }

    return answer;
  }
}
