/* problem
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 
reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int noUniform = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> reserveList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }
        for (int l : lost) {
            if (reserveList.contains(l)) {
                reserveList.remove(Integer.valueOf(l));
                continue;
            }
            lostList.add(l);
        }
        for (Integer l : lostList) {
            if (reserveList.indexOf(l - 1) != -1) { // 앞사람에게 빌리기
                reserveList.remove(Integer.valueOf(l - 1));
            } else if (reserveList.indexOf(l + 1) != -1) { // 뒷사람에게 빌리기
                reserveList.remove(Integer.valueOf(l + 1));
            } else {
                noUniform++;
            }
        }
        return n - noUniform;
    }
}

/*
 * strategy
 * 1. 무조건 수업 못 듣는 사람이 발생하는 경우: lost.length > reserve.length
 * 1-1. 무조건 수업 못 듣는 학생 수: lost.length - reserve.length
 * 2. lost: 0, reserve: 2, rest: 1
 * 
 * 작은 수는 작은 수에게, 큰 수는 큰 수에게 빌리면 더 많이 빌려줄 수 있지 않을까
 * 
 * 1. 그냥 앞에서부터 빌려주자
 * 2. 빌려준사람 reserve에서 제거
 * 
 * 
 */