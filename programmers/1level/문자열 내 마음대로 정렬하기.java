/* problem
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
 */

import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);

        String[] answers = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            answers[i] = strings[i].charAt(n) + "";
        }
        Arrays.sort(answers);

        for (String str : strings) {
            for (int i = 0; i < answers.length; i++) {
                if (Character.toString(str.charAt(n)).equals(answers[i])) {
                    answers[i] = str;
                    break;
                }
            }
        }
        return answers;
    }
}

/*
 * strategy
 * 1. 각 원소의 인덱스 n 문자 알아내기: for -> charAt(n)
 * 2. 알아낸 문자 정렬: sort() //"a","e","u"
 * 3. strings.charAt(n).equals(알아낸 문자) -> 알아낸 문자 배열에 string 저장 후 break
 * :for1= strings, for2= 알아낸 문자 배열
 * 같을 경우 sort 하기 위해 strings 먼저 정렬 한 번 해주기
 */