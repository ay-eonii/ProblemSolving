/* problem
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
*/

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }
        return true;
    }
}

// strategy
// phone_book의 길이는 1 이상 1,000,000 이하
// O(N)
// 오름차순 정렬
// while (index < phone_book.length)
// next_index.startsWith(index) == true -> return false
// else return true