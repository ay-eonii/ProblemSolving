class Solution {

  public int solution(String my_string) {
    String[] num = my_string.replaceAll("[^0-9]", " ").split(" ");

    int sum = 0;
    for (String str : num) {
      if (str.equals("")) {
        continue;
      } else {
        sum += Integer.parseInt(str.trim());
      }
    }
    return sum;
  }
}
