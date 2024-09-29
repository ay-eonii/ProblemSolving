package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            boolean flag = false;
            String line = br.readLine();
            if (line.equals(".")) {
                return;
            }
            Stack<Character> stack = new Stack<>();
            char[] input = line.toCharArray();
            for (char c : input) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    Character peek = stack.peek();
                    if (peek == '(') {
                        stack.pop();
                    } else {
                        flag = true;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    Character peek = stack.peek();
                    if (peek == '[') {
                        stack.pop();
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && !flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

// strategy


