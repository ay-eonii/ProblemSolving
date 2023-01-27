/* problem
두 정수 left와 right가 매개변수로 주어집니다. 
left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 
약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 */

//solution1
class Solution1 {
    public int solution(int left, int right) {

        int sum = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            sum += cnt % 2 == 1 ? -i : i;
        }
        return sum;
    }
}

// solution2
class Solution2 {
    public int solution(int left, int right) {

        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += i % Math.sqrt(i) == 0 ? -i : i;
        }
        return sum;
    }
}

/*
 * 제곱근으로 나누어 떨어지는 수는 약수의 개수가 홀수다..!!
 */
