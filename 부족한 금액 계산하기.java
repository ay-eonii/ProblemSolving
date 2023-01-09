// 내 풀이
class Solution {

  public long solution(int price, int money, int count) {
    long answer = -1;
    long pay = 0;
    for (int i = 1; i <= count; i++) {
      pay += price * i;
    }
    answer = pay - money;
    answer = answer < 0 ? 0 : answer;
    return answer;
  }
}

// 다른 사람 풀이
class Solution {

  public long solution(long price, long money, long count) {
    return Math.max(price * (count * (count + 1) / 2) - money, 0);
  }
}
