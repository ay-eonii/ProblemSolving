// Solve 1
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();
        for (int i = 0 ; i < len - 4 ; i++) {
            answer += "*";
        }
        for (int i = len - 4 ; i < len ; i++) {
            answer += phone_number.charAt(i);
        }

        return answer;
    }
}

// Solve 2
// 함수 활용
class Solution {
  public char getChar(int idx, int length, String phone_number) {
      return idx < length - 4 ? '*' : phone_number.charAt(idx);
  }
  
  public String solution(String phone_number) {
      String answer = "";
      int len = phone_number.length();

      for (int idx = 0 ; idx < len; idx++) {
          answer += getChar(idx, len, phone_number);
      }
      return answer;
  }
}
