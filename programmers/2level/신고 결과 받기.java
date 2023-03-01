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

/*
 * 1. report 내 중복 의미 X -> set
 * 2-0. report 순회
 * 2. 공백 앞: 신고자, 공백 뒤: 불량 이용자 : reportArr[] = report.split(" ")
 * 3. id별 신고자 배열만들기 -> 신고자는 true
 * 4. true 수 > k 라면 정지
 * 5. 신고자 인덱스 증가(메일보내기)
 * 
 */