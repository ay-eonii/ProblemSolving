/*
정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요.
단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
 */

import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {

        int length = numbers.length;
        int[] answer = new int[length];

        Stack<Integer> stack = new Stack<>();

        stack.push(numbers[length - 1]);
        answer[length - 1] = -1;

        for (int i = length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        return answer;
    }
}

// return: 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수 담은 배열
// 완전탐색. O(N^2) > 20억 이므로 시간초과

// stack 사용
// 뒤에서부터 push
// numbers 가 peek 보다 작으면 answer = peek
// numbers 가 peek 보다 크면 큰 거 나올때까지 pop
// stack.isEmpty() 라면 -1


// --------------------------
// 뒤에서부터 시작 -> for (i = numbers.length - 1; i >= 0; i--)
// answer[numbers.length - 1] = -1

// 확인해야 할 것
// 1) numbers에서 +1 인덱스 보다 작은지
//    -> answer[i] = numbers[i + 1]
// 2) answer에서 +1 인덱스보다 작은지
//    -> answer[i] = answer[i + 1]
// 3) 멀리 있는 큰 수 찾기
//    -> max 따로 저장
// 실패 => 원인: max 보다 작지만 가까운 수 존재


