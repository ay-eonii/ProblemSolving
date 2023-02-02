/* problem
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = new int[] { 1, 2, 3, 4, 5 };
        int[] student2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] student3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                scores[0]++;
            }
            if (answers[i] == student2[i % student2.length]) {
                scores[1]++;
            }
            if (answers[i] == student3[i % student3.length]) {
                scores[2]++;
            }
        }

        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == scores[i]) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(s -> s).toArray();
    }
}

/*
 * strategy
 * 1. 수포자들 답 규칙 파악
 * 2. 수포자 답: answers를 자신의 배열 길이로 나눈 나머지를 인덱스로 하는 자신의 답과 정답 비교
 * 3. 정답 수 cnt++;
 * 4. return 배열: ArrrayList에 저장 후 stream why? 동점자 몇 명일지 모름
 */