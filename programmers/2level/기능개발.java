/* problem
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] leftDays = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            leftDays[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                leftDays[i] += 1;
            }
        }

        int done = 0;
        int cnt = 0;
        while (done < progresses.length && done + cnt < progresses.length) {
            if (leftDays[done] < leftDays[done + cnt]) {
                done += cnt;
                list.add(cnt);
                cnt = 0;
                continue;
            }
            cnt++;
        }
        list.add(cnt);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}


/* strategy
1. 배열 순서대로 100달성하도록 채우기
2. 배포가능날짜: 100-progresses[0] / speeds[0] <- 나머지가 0일때
2-1. 100 - progresses[0] / speeds[0] + 1 <- 나머지가 0이 아닐때
3. 첫 번째 작업 100이상될때까지 나머지도 speed별로 작업
4. 첫번째 작업 100 넘으면 progresses중 100넘는 거 전부 배포 -> 개수 add
---
1. 남은 날짜 먼저 계산
*/