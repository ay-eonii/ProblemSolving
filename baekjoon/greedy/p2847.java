package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int bestIdx = n - 1;
        int sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            int tobe = score[bestIdx] - (bestIdx - i);
            if (score[i] < tobe) {
                bestIdx = i;
            } else {
                sum += Math.abs(tobe - score[i]);
            }
        }

        System.out.println(sum);
    }
}
