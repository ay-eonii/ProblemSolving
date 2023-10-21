/* problem
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 */

import java.util.Stack;

class Solution1 {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }
}


class Solution2 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(number);

        int delCount = 0;
        int index = 0;
        while (delCount != k) {
            index = index >= 0 ? index : 0;

            if ((index == sb.length() - 1) || (index + 1 < sb.length() && sb.charAt(index) < sb.charAt(index + 1))) {
                sb.deleteCharAt(index--);
                delCount++;
                continue;
            }
            index++;
        }

        return sb.toString();
    }
}

// strategy
// 2자리 이상, 1,000,000자리 이하 -> O(N)
// for(int i = 0; i < length; i++)
// 뒷자리 수 보다 작으면 charAt(i) 제거
// 크다면 다음 인덱스
// 제거 개수 == k 일때 까지
// 그럼 while(제거개수 != k)가 나을듯?

// 제거는 어떻게 하지?
// StringBuilder로
// 제거는 deleteCharAt
// 인덱스는 charAt
// 반환은 sb.toString()
