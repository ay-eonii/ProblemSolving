package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9012 {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split("");
            checkValid(inputs);
        }

        System.out.print(sb);
    }

    private static void checkValid(String[] inputs) {
        Stack<String> stack = new Stack<>();
        for (String input : inputs) {
            if (input.equals("(")) {
                stack.add(input);
            } else {
                if (stack.isEmpty()) {
                    sb.append("NO").append("\n");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            sb.append("YES").append("\n");
        } else {
            sb.append("NO").append("\n");
        }
    }
}
