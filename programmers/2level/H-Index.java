import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        if (citations.length < citations[0]) {
            return citations.length;
        }

        int i = citations.length - 1;
        int tmp = citations[i];
        while (tmp > citations[0] && i > 0) {
            if (tmp == citations[i - 1]) {
                i--;
                continue;
            }
            if (citations.length - i >= tmp && i < tmp) {
                return tmp;
            } else {
                tmp--;
            }
        }
        return citations[0];
    }
}

/*strategy
! 정렬을 사용하면 좀 빠르게 풀 수 있지 않을까?
1. Arrays.sort(citations)
2. h편의 논문은 h회 이상, n-h편은 h회 미만
3. length - i == 논문 수 , citations[i] == 인용 수
즉. length - i >= citations[i] && i <= citations[i + 1]

내림차순 정렬하면 좀 더 직관적이겠지만 Integer로 바꾸기 번거롭,,,
[22, 42]처럼 min > length 라면 return length;
*/