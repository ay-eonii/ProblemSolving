class Solution1 {

    public int solution(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2)
            if (num % i == 0)
                answer++;

        return answer;
    }
}
/* strategy1
 * "주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다"라는 정수론 정리
 * */

class Solution2 {
    public int solution(int n) {
        if (n < 3) {
            return 1;
        }
        int num = 2;
        int cnt = 0;
        while (true) {
            int sum = 0;

            for (int i = 1; i <= num; i++) {
                sum += i;
            }

            int tmp = n - sum;
            if (tmp < 0) {
                break;
            } else if (tmp % num == 0) {
                cnt++;
            }
            num++;
        }
        return cnt + 1;
    }
}

/* strategy2
 * k = (k-3)/2+1 (k-3)/2+2
 * k = (k-6)/3+1 (k-6)/3+2 (k-6)/3+3
 * */
