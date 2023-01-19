/* problem
모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 */

//solution1
import java.util.Arrays;

class Solution1 {

  public int solution(int[][] sizes) {
    for (int[] size : sizes) {
      Arrays.sort(size);
    }
    int widthMax = 0;
    int hightMax = 0;
    for (int i = 0; i < sizes.length; i++) {
      widthMax = (widthMax < sizes[i][0]) ? sizes[i][0] : widthMax;
      hightMax = (hightMax < sizes[i][1]) ? sizes[i][1] : hightMax;
    }
    return widthMax * hightMax;
  }
}

//solution2
class Solution {

  public int solution(int[][] sizes) {
    int length = 0, height = 0;
    for (int[] card : sizes) {
      length = Math.max(length, Math.max(card[0], card[1]));
      height = Math.max(height, Math.min(card[0], card[1]));
    }
    int answer = length * height;
    return answer;
  }
}
