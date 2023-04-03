/*
질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다.
이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = new int[]{3, 2, 1, 0, 1, 2, 3};

        Map<Character, Integer> map = new HashMap<>();
        map.put('R' , 0);
        map.put('T' , 0);
        map.put('F' , 0);
        map.put('C' , 0);
        map.put('M' , 0);
        map.put('J' , 0);
        map.put('A' , 0);
        map.put('N' , 0);

        for (int i = 0; i < choices.length; i++) {
            int sum = 0;
            if (choices[i] < 4) {
                sum = map.get(survey[i].charAt(0)) + score[choices[i] - 1];
                map.put(survey[i].charAt(0), sum);
            } else if (choices[i] > 4) {
                sum = map.get(survey[i].charAt(1)) + score[choices[i] - 1];
                map.put(survey[i].charAt(1), sum);
            }
        }

        String answer = "";
        answer = getAnswer(map, answer, 'R' , 'T');
        answer = getAnswer(map, answer, 'C' , 'F');
        answer = getAnswer(map, answer, 'J' , 'M');
        answer = getAnswer(map, answer, 'A' , 'N');
        return answer;
    }

    private static String getAnswer(Map<Character, Integer> map, String answer, Character t1, Character t2) {
        if (map.get(t1) >= map.get(t2)) {
            answer += t1;
        } else {
            answer += t2;
        }
        return answer;
    }
}


/* strategy
1. score[] = {3,2,1,0,1,2,3}
2. map?
3. 사전 순 : R, C, J, A
4. TR != RT score
5. choices < 4: survey[i].charAt(0)+1,2,3
5. choices > 4: survey[i].charAt(1)+1,2,3
*/