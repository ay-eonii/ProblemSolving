/* problem
문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 */

class Solution {

    private static final String P = "P";
    private static final String Y = "Y";

    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        for (String token : s.split("")) {
            String upperToken = token.toUpperCase();
            if (P.equals(upperToken)) {
                pCount++;
            }
            if (Y.equals(upperToken)) {
                yCount++;
            }
        }

        if (pCount == 0 && yCount == 0) {
            return true;
        }
        return pCount == yCount;
    }
}

// solution
// p, y 가 없는 경우는 true
// 대문자 소문자 구분 x
