/* problem
JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 */

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] cArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(cArr[i])) {
                answer += cArr[i] + "";
                continue;
            }
            if (i == 0 || cArr[i - 1] == ' ') {
                answer += Character.toUpperCase(cArr[i]) + "";
            } else {
                answer += Character.toLowerCase(cArr[i]) + "";
            }
        }
        return answer;
    }
}

/*
 * strategy
 * 0. toCharArray
 * 1. 첫 문자: index 0, 공백 다음 index
 * 2. 숫자인지: isDigit()
 * 3. 문자라면: 첫문자: toUpperCase(), 첫문자 아니면 toLowerCase()
 */