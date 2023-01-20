class Solution {

  public String solution(String my_string) {
    char[] my_char = my_string.toCharArray();
    String answer = "";
    for (char c : my_char) {
      if (Character.isUpperCase(c)) answer +=
        Character.toLowerCase(c); else answer += Character.toUpperCase(c);
    }

    return answer;
  }
}
