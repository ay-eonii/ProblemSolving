package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1459 {

    private static long X;
    private static long Y;
    private static long W;
    private static long S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        X = Integer.parseInt(inputs[0]);
        Y = Integer.parseInt(inputs[1]);
        W = Integer.parseInt(inputs[2]);
        S = Integer.parseInt(inputs[3]);

        long time = 0;

        long answer1, answer2, answer3 = 0;

        //1. 평행이동만
        answer1 = (X + Y) * W;

        //2. 대각선만
        answer2 = 0;
        if ((X + Y) % 2 == 0) {
            answer2 = Math.max(X, Y) * S;
        } else {
            answer2 = (Math.max(X, Y) - 1) * S + W;
        }

        // 가능한만큼 대각선 후 평행
        answer3 = (Math.min(X, Y)) * S + (Math.abs(X - Y)) * W;

        System.out.println(Math.min(answer1, Math.min(answer2, answer3)));
    }
}

// strategy
// 세로 X, 가로 y
// 0,0
// 가로 | 세로 | 대각선
// 완전탐색
// 도시 크기 무제한
