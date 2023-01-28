/* problem
양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 */

class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int temp = x;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return (temp % sum == 0) ? true : false;
    }
}

/*
 * strategy
 * 1. 각 자릿수 구하기: while(x>0), x%10
 * 2. 각 자릿수 더하기: sum
 * 3. x/sum -> temp에 x 저장
 */