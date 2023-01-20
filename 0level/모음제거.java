class Solution {

  public String solution(String my_string) {
    String answer = "";
    // char [] my_char = my_string.toCharArray();
    // for (char c : my_char) {
    //     if ( c!='a' && c!='e' && c!='i' && c!='o' && c!='u') {
    //         answer += c;
    //     }
    // }
    answer = my_string.replaceAll("[aeiou]", "");
    return answer;
  }
}
