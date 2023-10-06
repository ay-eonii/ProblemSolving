/* problem
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
*/

class Solution {

    private int[] sign;
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        sign = new int[numbers.length];
        for (int i = 0; i < sign.length; i++) {
            sign[i] = 1;
        }

        for (int i = 0; i <= sign.length; i++) {
            combi(numbers, target, i, 0);
        }

        return answer;
    }

    private void combi(int[] numbers, int target, int r, int start) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < sign.length; i++) {
                sum += numbers[i] * sign[i];
            }

            if (sum == target) answer++;
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            if (sign[i] > 0) {
                sign[i] = -1;
                combi(numbers, target, r - 1, i + 1);
                sign[i] = 1;
            }
        }
    }
}

// strategy
// 완전탐색

// 조합
// 선택된 숫자는 음수
// 아닌 숫자는 양수
// r은 0부터 numbers.length까지
