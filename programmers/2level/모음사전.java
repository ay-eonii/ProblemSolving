/* problem
단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 */
class Solution {
    public int solution(String word) {
        String str = "AEIOU";
        int[] x = {781, 156, 31, 6, 1};
        int index, result = word.length();

        for (int i = 0; i < word.length(); i++) {
            index = str.indexOf(word.charAt(i));
            result += x[i] * index;
        }

        return result;
    }
}

// strategy
// 마지막 자리: 1씩 증가
// 4번째자리: 6씩 증가 (마지막 없는 거 포함)
// 3번째자리: 4번째 증가 * 5 + 1
// 2번째자리: 3번째 증가 * 5 + 1
// 1번째자리: 2번째 증가 * 5 + 1