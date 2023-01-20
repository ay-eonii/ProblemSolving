class Solution {

  public int solution(String my_string) {
    int sum = 0;
    char[] my_char = my_string.toCharArray();
    for (char c : my_char) {
      int num = c - '0';
      if (0 <= num && num <= 9) {
        sum += num;
      }
    }
    return sum;
  }
}
