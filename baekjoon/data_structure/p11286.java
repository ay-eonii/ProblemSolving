package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class p11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Queue<Compare> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(new Compare(x, Math.abs(x)));
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().origin).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    static class Compare implements Comparable<Compare> {
        int origin;
        int abs;

        public Compare(int origin, int abs) {
            this.origin = origin;
            this.abs = abs;
        }

        @Override
        public int compareTo(Compare o) {
            if (abs == o.abs) {
                return this.origin - o.origin;
            }
            return abs - o.abs;
        }
    }
}

// strategy
// 배열에 정수 x (x ≠ 0)를 넣는다.
// 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거
// 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거
// -1, 1 -> -1
// 우선순위 큐
// 0기준
