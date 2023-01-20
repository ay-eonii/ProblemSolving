class Solution {

  public String solution(String s, int n) {
    String answer = "";
    char ch = ' ';

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        ch = (char) (s.charAt(i) + n); // char + int는 int로 자동 형변환 → char로 강제 형변환 필요
      } else {
        ch = s.charAt(i);
      }

      if (Character.isUpperCase(s.charAt(i)) && ch > 'Z') {
        ch -= 'Z' - 'A' + 1; // 복합 대입연산자 사용 시 자동 형변환X → char로 강제 형변환 필요X
      } else if (Character.isLowerCase(s.charAt(i)) && ch > 'z') {
        ch -= 'z' - 'a' + 1;
      }
      answer += String.valueOf(ch);
    }

    return answer;
  }
}
