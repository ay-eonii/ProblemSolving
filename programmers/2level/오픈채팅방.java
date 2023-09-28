/* problem
채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후,
최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final String ENTER = "Enter";
    private static final String CHANGE = "Change";
    private static final String LEAVE = "Leave";
    private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
    private static final String LEAVE_MESSAGE = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        int message = record.length;
        for (String str : record) {
            String[] split = str.split(" ");
            if (split[0].equals(ENTER)) {
                map.put(split[1], split[2]);
            }
            if (split[0].equals(CHANGE)) {
                map.put(split[1], split[2]);
                message--;
            }
        }

        String[] answer = new String[message];
        int index = 0;
        for (String str : record) {
            String[] split = str.split(" ");
            if (split[0].equals(ENTER)) {
                answer[index++] = map.get(split[1]) + ENTER_MESSAGE;
            }
            if (split[0].equals(LEAVE)) {
                answer[index++] = map.get(split[1]) + LEAVE_MESSAGE;
            }
        }
        return answer;
    }
}

/* strategy
Enter 아이디 닉네임
Leave 아이디
Change 아이디 닉네임

for (i = 0; i < record.length; i++)
Map<String, String> -> key: 아이디, value: 닉네임

for (i = 0; i < rocord.length; i++)
result[i] = map.get(record.split(" ")[1]) + ~~
*/