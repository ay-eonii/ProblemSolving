/*
질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다.
이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] scores = new int[]{3, 2, 1, 0, 1, 2, 3};
        Character[][] tests = new Character[][]{{'R' , 'T'}, {'C' , 'F'}, {'J' , 'M'}, {'A' , 'N'}};

        Map<Character, Integer> map = new HashMap<>();
        for (Character[] test : tests) {
            map.put(test[0] , 0);
            map.put(test[1] , 0);
        }

        for (int i = 0; i < choices.length; i++) {
            int sum = 0;
            if (choices[i] < 4) {
                sum = map.get(survey[i].charAt(0)) + scores[choices[i] - 1];
                map.put(survey[i].charAt(0), sum);
            } else if (choices[i] > 4) {
                sum = map.get(survey[i].charAt(1)) + scores[choices[i] - 1];
                map.put(survey[i].charAt(1), sum);
            }
        }

        String answer = "";
        for (Character[] test : tests) {
            answer += map.get(test[0]) >= map.get(test[1]) ? test[0] : test[1];
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