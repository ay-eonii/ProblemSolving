package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class p2785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] chain = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            chain[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(chain);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(chain[i]);
        }

        int answer = 0;
        while (deque.size() != 1) {
            Integer first = deque.pollFirst();
            if (first == 0) {
                first = deque.pollFirst();
            }
            deque.addFirst(first - 1);

            if (deque.size() >= 2) {
                Integer right = deque.pollLast();
                Integer left = deque.pollLast();
                deque.addLast(right + left);
                answer++;
            }
        }

        System.out.println(answer);
    }
}

// 가장 짧은 체인으로 고리를 만들어 가장 긴 체인부터 연결하며 체인의 개수가 1이 될 때까지 반복해나간다.
