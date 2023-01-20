// solution 1
import java.util.Stack;

class Solution1 {

  public int solution(int n) {
    Stack<Integer> stack = new Stack<>();
    while (n > 2) {
      stack.push(n % 3);
      n /= 3;
    }
    stack.push(n);

    int answer = 0;
    int i = 0;
    while (stack.size() > 0) {
      answer += stack.pop() * Math.pow(3, i++);
    }
    return answer;
  }
}

// solution 2
class Solution2 {

  public int solution(int n) {
    String str = "";
    while (n > 2) {
      str += n % 3;
      n /= 3;
    }
    str += n;

    return Integer.parseInt(str, 3);
  }
}
