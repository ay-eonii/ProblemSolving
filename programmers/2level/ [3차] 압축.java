/* problem
주어진 문자열을 압축한 후의 사전 색인 번호를 배열로 출력하라.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<String> dictionary = new ArrayList<>(Arrays.asList(
                " ", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
        );

        int start = 0;
        int end = 1;
        String sub = "";
        List<Integer> answer = new ArrayList<>();

        while (start < msg.length() && end <= msg.length()) {
            int index = dictionary.indexOf(sub);
            sub = msg.substring(start, end);
            if (dictionary.contains(sub)) {
                end++;
                continue;
            }
            dictionary.add(sub);
            answer.add(index);
            start = end - 1;
        }
        answer.add(dictionary.indexOf(sub));

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

/* strategy
1. List<String> 사용
2. 인덱스는 출력 값은 입력
3-1. List에 있다면 인덱스
3-2. List에 없다면 add
4. while start < msg.length()
5. msg.substring(start, end)
6-1. msg.substring(start, end) + msg.charAt(end) 가 List에 있다 -> end++
6-2. 없다 -> list.add -> answer.add(substring(start, end)의 인덱스)
7. start = end
*/