class Solution {

  public int solution(int a, int b) {
    int max = 1;
    for (int i = 1; i <= Math.max(a, b); i++) {
      max = (a % i == 0 && b % i == 0) ? i : max;
    }
    b /= max;
    while (b % 2 == 0) {
      b /= 2;
    }
    while (b % 5 == 0) {
      b /= 5;
    }
    return (b == 1) ? 1 : 2;
  }
}
