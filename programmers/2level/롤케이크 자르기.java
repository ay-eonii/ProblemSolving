/* problem
롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때,
롤케이크를 공평하게 자르는 방법의 수를 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        Variable left = new Variable(topping.length);
        Variable right = new Variable(topping.length);

        left.putLeftVariables(topping);
        right.putRightVariables(topping);

        int[] leftVariables = left.getVariables();
        int[] rightVariables = right.getVariables();

        int answer = 0;
        for (int i = 0; i < leftVariables.length - 1; i++) {
            if (leftVariables[i] == rightVariables[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}

class Variable {
    private final int[] variables;
    private final Set<Integer> set;

    public Variable(int length) {
        this.variables = new int[length];
        this.set = new HashSet<>();
    }

    public void putRightVariables(int[] topping) {
        int count = 0;
        for (int i = topping.length - 1; i >= 0; i--) {
            if (!this.set.contains(topping[i])) {
                this.set.add(topping[i]);
                count++;
            }
            this.variables[i] = count;
        }
    }

    public void putLeftVariables(int[] topping) {
        int count = 0;
        for (int i = 0; i < topping.length; i++) {
            if (!this.set.contains(topping[i])) {
                this.set.add(topping[i]);
                count++;
            }
            this.variables[i] = count;
        }
    }

    public int[] getVariables() {
        return this.variables;
    }
}

// HashSet.contains(k) -> 시간복잡도 O(1)... 시간초과 안남,
// 좌부터 시작
// 우부터 시작
// left: 1 2 2 3 3 4 4 4
// right:4 4 4 4 3 3 2 1
// left[i] == right[i+1] ? count++
