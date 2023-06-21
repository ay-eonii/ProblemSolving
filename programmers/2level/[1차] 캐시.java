/* problem
DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> queue = new LinkedList<>();
        int time = 0;
        for (String city : cities) {
            city = city.toLowerCase();

            if (queue.contains(city)) {
                time++;
                queue.remove(city);
            } else {
                time += 5;
            }
            queue.add(city);

            if (queue.size() > cacheSize) {
                queue.poll();
            }
        }
        return time;
    }
}

/* strategy
Least Recently Used라면... Queue 사용?
1. 도시 이름이 Queue에 없다면
 => 캐시 크기 상관없이 Queue.add : +5sec
 1-1. 캐시 max -> add 전 Queue.poll
 1-2. 캐시 not max -> 그냥 add
2. 도시 이름이 Queue에 있다면
 => 캐시 크기 상관없이 +1sec
 2-1. poll & add
*/