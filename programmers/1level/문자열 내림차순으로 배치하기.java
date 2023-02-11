/* problem
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 */

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split("");
        Arrays.sort(sArr, Collections.reverseOrder());
        String answer = "";
        for (String str : sArr) {
            answer += str;
        }
        return answer;
    }

}
/*
 * strategy
 * 1. Arrays.sort(array, Collections.reverseOrder()): primitive type(ex. char) X
 * 2. 내림차순: 소문자 -> 대문자
 */