import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            for (int[] b : board) {
                if (b[move - 1] != 0) {
                    answer = compareDoll(stack, answer, move, b);
                    break;
                }
            }
        }
        return answer;
    }

    private static int compareDoll(Stack<Integer> stack, int answer, int move, int[] b) {
        if (!stack.isEmpty() && stack.peek() == b[move - 1]) {
            stack.pop();
            answer += 2;
        } else {
            stack.push(b[move - 1]);
        }
        b[move - 1] = 0;
        return answer;
    }
}
/*
0. for(moves) for([]b:board[][])
1. 뽑은 인형 : board[top][move - 1]
1-1. top: 0이 아닌거
1-2. 뽑고 나면 0으로 바꾸기
2. if(!stack.isEmpty)
2-1. stack.top == 뽑은 인형 stack.pop(); cnt++;
2-2. stack.top != 뽑은 인형 뽑은 인형 stack에 저장
3. if(stack.isEmpty) 뽑은 인형 stack에 저장


스택이 empty 상관없이 stack에 저장
그렇다면 먼저 뽑은 인형이 같은지 다른지 판단!

2. stack.top == 뽑은 인형 stack.pop(); cnt++; <- 스택 !isEmpty
3. stack.top != 뽑은 인형 ? 뽑은 인형 stack에 저장

*/
