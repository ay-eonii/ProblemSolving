/* problem
머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 
네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 
문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int solution(String[] babbling) {
        String[] word = new String[] { "aya", "ye", "woo", "ma" };
        int answer = 0;

        for (String b : babbling) {
            int cnt = 0;
            for (String w : word) {
                int index;
                while (b.contains(w)) {
                    index = b.indexOf(w);
                    b = b.replaceFirst(w, "_");
                    cnt++;
                    if (index + 1 == b.indexOf(w)) {
                        break;
                    }
                }
            }
            if (b.length() == cnt) {
                answer++;
            }
        }
        return answer;
    }
}

/*
 * strategy
 * 1. babbling 배열 순회
 * 2. 가능한 발음(word) 배열 순회
 * 3. if(babbling.contains(word)) replace.(word,"")
 * 4. if(babbling.length()==0) answer++
 * 
 * word가 여러번 나올 수 있음 단, 연속해서는 못함
 * word 포함할때마다 인덱스 확인
 */