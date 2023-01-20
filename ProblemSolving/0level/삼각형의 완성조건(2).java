class Solution {

  public int solution(int[] sides) {
    int answer = 0;
    int longest = Math.max(sides[0], sides[1]);
    int sum = sides[0] + sides[1];
    // 나머지 한 변이 가장 긴 경우
    for (int i = longest + 1; i < sum; i++) {
      answer++;
    }
    // 배열에 가장 긴 변이 있는 경우
    for (int i = longest; i > 2 * longest - sum; i--) {
      answer++;
    }
    return answer;
  }
}
