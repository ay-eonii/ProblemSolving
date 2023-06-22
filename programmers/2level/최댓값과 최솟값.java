/* problem
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
s에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
*/

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] i = new int[arr.length];
        for (int k = 0; k < i.length; k++) {
            i[k] = Integer.parseInt(arr[k]);
        }

        int maxValue = Arrays.stream(i)
                .max()
                .getAsInt();
        int minValue = Arrays.stream(i)
                .min()
                .getAsInt();

        return minValue + " " + maxValue;
    }
}