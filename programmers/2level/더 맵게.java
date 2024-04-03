import java.util.PriorityQueue;

/* problem
`섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)`
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 */

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilles = new PriorityQueue<>();
        for (int s : scoville) {
            scovilles.add(s);
        }

        int count = 0;
        while (scovilles.size() >= 2 && scovilles.peek() < K) {
            int leastSpicy = scovilles.poll();
            int secondNotSpicy = scovilles.poll() * 2;
            scovilles.add(leastSpicy + secondNotSpicy);
            count++;
        }
        return (scovilles.size() == 1 && scovilles.peek() < K) ? -1 : count;
    }
}

// strategy
// 모든 음식의 스코빌 지수 K 이상 될때까지
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
// 2 <= scoville.length <= 1,000,000
// 0 <= K <= 1,000,000,000
// 0 <= scoville[i] <= 1,000,000 이하

// heap