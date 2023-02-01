/* problem
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 */

class Solution1 {
    public int solution(int n) {
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        arr[0] = -1;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i + i; j <= n; j += i) {
                if (arr[j] % arr[i] == 0) {
                    arr[j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                answer++;
            }
        }
        return answer;
    }
}

class Solution2 {
    public int solution(int n) {
        int answer = 0;
        int arr[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int k = i; k <= n; k += i) {
                    arr[k] = 1;
                }
            }
        }
        return answer;
    }
}

/*
 * strategy - 에라토스테네스의 체
 * 1. 2의 배수 제외 (2는 소수)
 * 2. 3의 배수 제외 (3은 소수)
 * 3. 5의 배수 제외 (5은 소수)
 * 4. ...반복
 * 
 * 1~n 배열에서
 * 1) 2빼고 2의 배수 0으로 저장
 * 2) 3빼고 3의 배수 0으로 저장
 * 3) 4는 1)에서 제외
 * 4) 5빼고 5의 배수 0으로 저장
 * -> 배열 순차적으로 인덱스 접근
 */