/* problem
숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서, 
이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.
 */

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String part = t.substring(i, i + p.length());
            if (Long.parseLong(part) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}

/*
 * strategy
 * 1. p문자열 길이만큼 t자르기: substring(start, end)
 * 2. p랑 비교
 * 
 * 데이터타입 확인하기!!
 * 제한사항: p의 길이 <= 18
 * 즉, int로 풀 수 없음 -> Long
 * Integer.parseInt 대신, Long.parseLong
 */