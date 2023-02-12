/* problem
머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 
조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다. 
문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int solution(String[] babbling) {
        String[] word = new String[] { "aya", "ye", "woo", "ma" };
        int answer = 0;

        for (String b : babbling) {
            int cnt = 0;
            for (String w : word) {
                if (b.contains(w)) {
                    b = b.replaceFirst(w, " ");
                    cnt++;
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
 * word가 한번씩 밖에 쓸 수 없다면 replaceFirst
 */