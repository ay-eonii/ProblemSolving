package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] problems = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            problems[i][0] = Integer.parseInt(inputs[0]);
            problems[i][1] = Integer.parseInt(inputs[1]);
        }

        Arrays.sort(problems, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        Queue<Integer> pq = new PriorityQueue<>();
        for (int[] problem : problems) {
            if (pq.size() < problem[0]) {
                pq.add(problem[1]);
            } else {
                if (pq.peek() > problem[1]) {
                    continue;
                }
                pq.poll();
                pq.add(problem[1]);
            }
        }

        int answer = 0;
        for (Integer ramen : pq) {
            answer += ramen;
        }

        System.out.println(answer);
    }
}
