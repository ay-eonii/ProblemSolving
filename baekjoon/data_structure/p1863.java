package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int y = Integer.parseInt(inputs[1]);

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                count++;
            }

            if (y == 0 || (!stack.isEmpty() && stack.peek() == y)) {
                continue;
            }
            stack.push(y);
        }

        while (!stack.isEmpty()) {
            stack.pop();
            count++;
        }

        System.out.println(count);
    }
}
