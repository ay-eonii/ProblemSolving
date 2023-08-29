/* problem
현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와,
몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때,
해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.
*/

import java.util.*;

class Solution1 {
    public int solution(int[] priorities, int location) {
        Queue<Integer> place = new LinkedList<>();
        Queue<Integer> process = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            process.add(priorities[i]);
            if (i == location) {
                place.add(1);
                continue;
            }
            place.add(0);
        }

        priorities = Arrays.stream(priorities).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        int answer = 1;
        int i = 0;
        while (!process.isEmpty()) {
            if (process.peek() == priorities[i]) {
                if (place.peek() == 1) {
                    return answer;
                }
                process.remove();
                place.remove();
                answer++;
                i++;
                continue;
            }
            process.add(process.poll());
            place.add(place.poll());
        }

        return answer;
    }
}

class Solution2 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            pq.add(priority);
        }

        int answer = 1;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    answer++;
                    pq.poll();
                }
            }
        }
        return answer;
    }
}

/*
1. Queue 두 개 -> 우선순위, 프로세스: 동시에 움직임
2. location[] 바탕 프로세스를 Queue<Integer>에서 1(location), 0 로 만들기
3. location 내림차순 정렬
4. location[0] == queue.peek() 일때까지 queue 돌리기
*/

/* strategy
1. Queue 두 개 -> 우선순위, 프로세스: 동시에 움직임
2. location[] 바탕 프로세스를 Queue<Integer>에서 1(location), 0 로 만들기
3. location 내림차순 정렬
4. location[0] == queue.peek() 일때까지 queue 돌리기
*/