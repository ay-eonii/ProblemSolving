class Solution2 {

  public static int solution(String[] s1, String[] s2) {
    int cnt = 0;
    for (int i = 0; i < s1.length; i++) {
      for (int j = 0; j < s2.length; j++) {
        if (s1[i].equals(s2[j])) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    String[] a = { "a", "b", "c" };
    String[] b = { "com", "b", "d", "p", "c" };

    System.out.println(solution(a, b));
  }
}
