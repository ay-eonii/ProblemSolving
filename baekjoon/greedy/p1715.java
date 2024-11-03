package baekjoon.greedy;

/*
1. 아이디어
- 작은 것부터 묶기
- 정렬
- (a1+a2)+(a1+a2+a3)+(a1+a2+a3+a4)+...
- 누적합
---- 오답
- 카드 묶음 2개를 합치면 -> 새로운 카드 묶음 1개
- 새롭게 만들어진 카드묶음 1개가 이전에 정렬했던 값들보다 작거나 클 수 있음 -> 재정렬 필요
- 우선순위 큐 사용
2. 시간복잡도
3. 자료구조
- 묶음: PriorityQueue<Integer>
- 합 : int[]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (pq.size() > 1) {
            int compareCount = pq.poll() + pq.poll();
            answer += compareCount;
            pq.add(compareCount);
        }

        System.out.print(answer);
    }
}
