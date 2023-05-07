import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() && c == ')') {
                return false;
            }
            if (c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
/* strategy
1. 스택
2. s.split("")
3. for-s[] { stack.push("(") }
4. if: stack.top() == "(" && s[i] == )
5. stack.pop(); i++
6. if(stack.isEmpty()) return true
*/