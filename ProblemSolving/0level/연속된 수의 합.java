class Solution {

  public int[] solution(int num, int total) {
    int[] answer = new int[num];
    int midNum = total / num;

    for (int i = 0; i < num; i++) {
      if (num % 2 == 1) {
        answer[i] = midNum - num / 2;
      } else {
        answer[i] = midNum - (num / 2 - 1);
      }
      midNum++;
    }
    return answer;
  }
}
