/* problem
1. 숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
2. 10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.
위 게임 규칙에 따라 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만들려고 한다. 프로그램을 구현하라.
 */

class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        int number = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(number, n));
            number++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; i < t * m; i += m) {
            answer.append(sb.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
}

/* strategy
10진수 숫자의 증가대로 말하는 게 아니고, n진수에서 한글자씩 말하기
ex) 0->"0", 1->1, 2->"1"0, 3->"1"1, 4->"1"00
1. (10진법) 어느 숫자까지 가야할까? : n진법으로 변환한 수 나열했을때 t*m을 넘을 때까지
ex) 011011100
2. n진법 구하기 -> Integer.toString(k, n)
3. n진법은 하나의 문자열에 계속 추가
4. 튜브가 말할 숫자는 for(int i = p - 1; i < 문자열길이; i += m)
*/
