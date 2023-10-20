/* problem
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 */

class Solution1 {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}

/**
 * 시간초과.ver
 */
class Solution2 {
    private final String[] init = {"4", "1", "2", "4"};
    private String[] number;
    private StringBuilder sb;

    public String solution(int n) {
        number = new String[n + 1];

        int i = 0;
        while (i < n + 1 && i < init.length) {
            number[i] = init[i];
            i++;
        }

        for (int j = 4; j < n + 1; j++) {
            number[j] = "";
        }

        return recur(n);
    }

    private String recur(int n) {

        if (!number[n].equals("")) {
            return number[n];
        }

        sb = new StringBuilder();
        return number[n] = sb.append(recur((n - 1) / 3)).append(number[n % 3]).toString();
    }
}

// 규칙찾기

// number = new String[n + 1];
// 나머지: 1->1 2->2 0->4
// 1의 자리 수는 n%3 나머지 패턴
// 앞에는 재귀로 해결 가능