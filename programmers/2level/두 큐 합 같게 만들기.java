/* problem
길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다.
각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요.
단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
 */

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = getSum(queue1);
        long q2Sum = getSum(queue2);
        long total = q1Sum + q2Sum;

        if (total % 2 == 1) {
            return -1;
        }

        long average = total / 2;
        int q1Max = getMax(queue1);
        int q2Max = getMax(queue2);
        if (Math.max(q1Max, q2Max) > average) {
            return -1;
        }

        int q1Idx = 0;
        int q2Idx = 0;
        int answer = 0;
        int length = queue1.length;
        while (q1Sum != average) {
            if (answer > length * 4) return -1;
            if (q1Sum < average) {
                if (q2Idx < length) {
                    q1Sum += queue2[q2Idx];
                } else {
                    q1Sum += queue1[q2Idx - length];
                    if (q2Idx + 1 == length * 2) {
                        q2Idx = -1;
                    }
                }
                q2Idx++;
            } else {
                if (q1Idx < length) {
                    q1Sum -= queue1[q1Idx];
                } else {
                    q1Sum -= queue2[q1Idx - length];
                    if (q1Idx + 1 == length * 2) {
                        q1Idx = -1;
                    }
                }
                q1Idx++;
            }
            answer++;
        }
        return answer;
    }

    private long getSum(int[] queue) {
        long sum = 0;
        for (int q : queue) {
            sum += q;
        }
        return sum;
    }

    private int getMax(int[] queue) {
        int max = Integer.MIN_VALUE;
        for (int q : queue) {
            max = Math.max(q, max);
        }
        return max;
    }
}

// strategy
// 합계는 Long

// queue1 에서 처음부터 시작해서 합 구하기 : 3 5 12 14
// 14 < 15 니까 queue2에서 가져오기(안 가져온 제일 처음 인덱스:queue2[0] : 4)
// 18 > 15 니까 제일 queue1 제거 (안 뺀 제일 처음 인덱스: queue1[0]: 3)
// 15 == 15

// 추상화하면
// queue1.sum() < (queue1.sum() + queue2.sum()) / 2 ? queue1.sum() + queue2[idx] && queue2.sum() - queue2[idx]
// queue1.sum() > (queue1.sum() + queue2.sum()) / 2 ? queue1.remove() && queue2.add()
// queue1 or queue2 끝까지 갔다면 queue2 queue1 로