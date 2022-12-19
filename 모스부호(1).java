import java.util.Arrays;

class Solution {

  public String solution(String letter) {
    String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."  };
    String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
                         "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    String[] letterArray = letter.split(" ");
    String answer = "";
    int index = 0;

    for (String str : letterArray) {
      index = Arrays.asList(morse).indexOf(str);
      answer += alphabet[index];
    }

    return answer;
  }
}
