// 내 풀이
class Solution {

  public int solution(String A, String B) {
    int answer = 0;

    for (int i = 0; i < A.length(); i++) {
      String lastStr = Character.toString(B.charAt(i));
      B = B.concat(lastStr);
      answer = (B.indexOf(A) > -1) ? B.indexOf(A) : -1;
    }

    return answer;
  }
}

// 다른 사람 풀이
class Solution {

  public int solution(String A, String B) {
    String tempB = B.repeat(3);
    return tempB.indexOf(A);
  }
}
