package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int current = 1;
        for (int i = 0; i < n; i++) {
            while (current <= arr[i]) {
                stack.add(current);
                current++;
                sb.append("+").append("\n");
            }
            if (stack.peek() == arr[i]) {
                Integer pop = stack.pop();
                sb.append("-").append("\n");
                answer.add(pop);
            }
        }

        if (answer.size() != n) {
            System.out.print("NO");
        } else {
            System.out.print(sb);
        }
    }
}

// strategy
// push : +
// pop : -
// 스택에 push하는 순서는 반드시 오름차순
