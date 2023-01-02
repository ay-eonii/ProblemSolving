// 내 풀이
import java.util.*;

class Solution {

  public int solution(int n) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 100; i++) {
      list.add(i);
    }

    List<Integer> list3x = new ArrayList<>();
    int num = 1;
    int temp;
    boolean flag = true;

    while (list3x.size() <= 100) {
      temp = num;
      while (num > 0) {
        if (num % 10 != 3) {
          flag = true;
        } else {
          flag = false;
          break;
        }
        num /= 10;
      }
      num = temp;

      if (num % 3 != 0 && flag == true) {
        list3x.add(num);
      }
      num++;
    }

    return list3x.get(list.indexOf(n));
  }
}

// 다른 사람 풀이
class Solution {

  public int solution(int n) {
    int answer = 0;

    for (int i = 1; i <= n; i++) {
      answer++;
      if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
        i--;
      }
    }

    return answer;
  }
}
