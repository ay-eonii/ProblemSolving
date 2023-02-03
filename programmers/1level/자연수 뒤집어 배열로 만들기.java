/* problem
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 */

//solution1
import java.util.List;
import java.util.ArrayList;

class Solution1 {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add((int) (n % 10));
            n /= 10;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}

// solution2
class Solution2 {
    public int[] solution(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt = 0;

        while (n > 0) {
            answer[cnt++] = (int) (n % 10);
            n /= 10;
        }
        return answer;
    }
}

/*
 * strategy
 * 1. 각 자리 수 구하기 -> n % 10
 * 2. 배열에 추가 (list -> toArray)
 */