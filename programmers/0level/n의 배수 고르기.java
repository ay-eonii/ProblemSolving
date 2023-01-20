import java.util.*;

class Solution {

  public int[] solution(int n, int[] numlist) {
    int cnt = 0;
    for (int num : numlist) {
      if (num % n == 0) {
        cnt++;
      }
    }

    int[] answer = new int[cnt];

    int index = 0;
    for (int num : numlist) {
      if (num % n == 0) {
        answer[index] = num;
        index++;
      }
    }
    return answer;
    //         ArrayList<Integer> answer = new ArrayList<>();

    //         for (int num : numlist) {
    //             if (num%n==0) answer.add(num);
    //         }
    //         return answer;
  }
}
