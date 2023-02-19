/* problem
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 */

class Solution {
    public String solution(String s) {
        String answer = "";
        int mid = s.length() / 2;
        if (s.length() % 2 == 1) {
            answer = s.charAt(mid) + "";
        } else {
            answer = s.charAt(mid - 1) + "" + s.charAt(mid) + "";
        }
        return answer;
    }
}

/*
 * strategy
 * 1. 길이 구하기
 * 1-1. 홀: 길이/2
 * 1-2. 짝: 길이/2 - 1, 길이/2
 */