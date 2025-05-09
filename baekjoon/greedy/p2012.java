package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rank);

        long answer = 0;
        for (int i = 1; i < n + 1; i++) {
            answer += Math.abs(i - rank[i]);
        }

        System.out.println(answer);
    }
}
