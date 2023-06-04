import java.util.Stack;

class Solution {
    private String start = "({[";
    private String end = ")}]";

    public int solution(String s) {
        String newS = s;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(newS)) {
                answer++;
            }

            newS = newS.substring(1) + newS.charAt(0);
        }
        return answer;
    }

    private boolean check(String str) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            if (end.indexOf(str.charAt(i)) == -1) {
                stack.push(start.indexOf(str.charAt(i)));
                continue;
            }

            if (!stack.isEmpty() && end.indexOf(str.charAt(i)) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}