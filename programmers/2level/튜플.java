/* problem
특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        String[] strs = s.replaceAll("[{}]", " ").trim().split(" , ");
        int[] answer = new int[strs.length];
        Set<String> set = new HashSet<>();
        Arrays.sort(strs, Comparator.comparingInt(String::length));

        int i = 0;
        for (String str : strs) {
            for (String st : str.split(",")) {
                if (set.add(st)) {
                    answer[i] = Integer.parseInt(st);
                    i++;
                }
            }
        }
        return answer;
    }
}

/* strategy
1. "{{", "}}", "},{" 로 split 하여 숫자만 남기기
2. 튜플에는 순서가 있음.
2-1. length 짧은 거 부터 answer에 저장
2-2. 이후부터 answer에 없는 거 저장
*/