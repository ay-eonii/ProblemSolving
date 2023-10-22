/* problem
수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때,
위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요.
이때 수열의 인덱스는 0부터 시작합니다.
 */

class Solution {
    public int[] solution(int[] sequence, int k) {
        int length = sequence.length;
        int[] sum = new int[length];

        int[] answer = new int[2];
        answer[0] = answer[1] = length;
        int min = length;

        sum[0] = sequence[0];
        if (sum[0] == k) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + sequence[i];
            if (sum[i] == k) {
                answer[0] = 0;
                answer[1] = i;
                min = i + 1;
            }
        }

        int end = length - 1;
        int start = end - 1;
        while (start < end && start >= 0 && start < length && end >= 0 && end < length) {
            int temp = sum[end] - sum[start];
            if (temp == k && min >= end - start + 1) {
                answer[0] = start + 1;
                answer[1] = end;
                min = end - start + 1;
            }

            if (temp >= k) {
                end--;
            }
            start--;
        }
        return answer;
    }
}

// strategy
// sequence 오름차순
// 두 인덱스 사이의 원소 합 == k
// 길이 짧은 수열
// 길이가 같다면 인덱스가 작은 수열

// 누적합 && 투포인터
// sum[i] - sum[j] > k ? i-- or j++
// 1. 길이 짧게 시작.
// 2. sum[start] - sum[end] >= k ? 크기 유지하고 인덱스 한 칸 앞으로
// 3. sum[start] - sum[end] < k ? 시작 인덱스만 앞으로
// 우선순위1) 길이: answer[1] - answer[0] + 1
// 우선순위2) i가 작은거
// 4. k도 만족하고 길이도 더 작아야야 함.