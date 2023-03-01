/* problem
신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.

각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.   

따라서 "muzi"는 처리 결과 메일을 2회, "frodo"와 "apeach"는 각각 처리 결과 메일을 1회 받게 됩니다.

이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report, 
정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때, 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>(Arrays.asList(report));
        boolean[][] error = new boolean[id_list.length][id_list.length];
        int[] answer = new int[id_list.length];
        for (String s : set) {
            String reportArr[] = s.split(" ");
            int reportIndex = Arrays.asList(id_list).indexOf(reportArr[0]);
            int errorIndex = Arrays.asList(id_list).indexOf(reportArr[1]);
            error[errorIndex][reportIndex] = true;
        }
        for (boolean[] e : error) {
            int cnt = 0;
            for (boolean t : e) {
                if (t) {
                    cnt++;
                }
            }
            if (cnt >= k) {
                for (int i = 0; i < e.length; i++) {
                    if (e[i]) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }
}

/* strategy
 * 1. report 내 중복 의미 X -> set
 * 2-0. report 순회
 * 2. 공백 앞: 신고자, 공백 뒤: 불량 이용자 : reportArr[] = report.split(" ")
 * 3. id별 신고자 배열만들기 -> 신고자는 true
 * 4. true 수 > k 라면 정지
 * 5. 신고자 인덱스 증가(메일보내기)
 */