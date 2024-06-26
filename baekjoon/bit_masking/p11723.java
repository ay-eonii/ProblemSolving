package baekjoon.bit_masking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int A = 0;
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];
            if ("all".equals(command)) {
                for (int j = 1; j <= 20; j++) {
                    A |= (1 << j);
                }
            } else if ("empty".equals(command)) {
                A = 0;
            } else {
                int number = Integer.parseInt(inputs[1]);
                if ("add".equals(command)) {
                    A |= (1 << number);
                } else if ("remove".equals(command)) {
                    A &= ~(1 << number);
                } else if ("toggle".equals(command)) {
                    A ^= (1 << number);
                } else {
                    sb.append(((A & (1 << number)) == (1 << number)) ? 1 : 0).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}

// strategy
// 연산 최대 3천만
// hash
// add 중복 x
// check : contains
// set

// 비트마스킹
