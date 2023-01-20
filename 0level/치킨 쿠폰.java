class Solution {

  public int solution(int chicken) {
    int coupon = chicken % 10;
    chicken /= 10;
    coupon += chicken;

    int answer = chicken;

    while (coupon >= 10) {
      chicken = coupon / 10;
      answer += chicken;

      coupon %= 10;

      coupon += chicken;
    }

    return answer;
  }
}
