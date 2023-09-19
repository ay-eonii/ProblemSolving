/* problem
 - 0P0처럼 소수 양쪽에 0이 있는 경우
 - P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
 - 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
 - P처럼 소수 양쪽에 아무것도 없는 경우
   - 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.

정수 n과 k가 매개변수로 주어집니다.
n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
 */

class Solution {
    public int solution(int n, int k) {
        String[] numbers = Integer.toString(n, k).split("0");

        int answer = 0;
        for (String number : numbers) {
            if (number.equals("") || number.equals("1")) {
                continue;
            }

            if (isPrime(Long.parseLong(number))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(long longNum) {
        for (int i = 2; i <= Math.sqrt(longNum); i++) {
            if (longNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/* strategy
소수 구하기 -> 정수론
10진수 n -> k진수 중 소수
n은 백만 이하. & 3진수에서 10진수 -> 진수는 string으로
 - k == 10 이라면 그냥 진행
n이 0이 될때까지 k로 나누기
앞에다가 나머지 붙이기

0을 기준으로 소수 판별 -> string.split("0")

--- 에라토스테네스의 체 --- -> long 사이즈 만큼 인덱스 감당 불가
가장 큰 수 기준으로 정수론 에라토스테네스의 체 적용
 - 가장 큰 수 크기의 배열 선언
 - 2부터 Math.sqrt(split[i])까지
 - 해당 수는 두고, 그 수의 배수는 다 0으로 변경
 - 0이면 continue

split[] 숫자 순회하면서 primeNum[split[]]의 값이 0인지 확인
0이 아니라면 answer++
*/
