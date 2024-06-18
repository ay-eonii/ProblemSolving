package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class p5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] commands = br.readLine().split("");

            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String inputSubstring = input.substring(1, input.length() - 1);
            String[] arr = inputSubstring.split(",");

            boolean reverse = false;
            int front = 0; // 앞에서 삭제
            int back = 0; // 뒤에서 삭제
            for (String command : commands) {
                if ("R".equals(command)) {
                    reverse = !reverse;
                }
                if ("D".equals(command)) {
                    if (reverse) {
                        back++;
                    } else {
                        front++;
                    }
                }
            }

            if (front + back > n) {
                sb.append("error").append("\n");
                continue;
            }

            StringJoiner sj = new StringJoiner(",", "[", "]");
            if (reverse) { // 뒤집음
                for (int j = n - back - 1; j >= front; j--) { // 뒤에서 지우고 시작한 곳부터
                    sj.add(arr[j]);
                }
            } else {
                for (int j = front; j < n - back; j++) {
                    sj.add(arr[j]);
                }
            }

            sb.append(sj).append("\n");
        }

        System.out.print(sb);
    }
}

// strategy
//1,2,3,4
// RDD
// true -> 4321 -> 2 => 4 - 2 => 0, 2
// DDR 2, true
// 43
// 4321 -> 0,2
