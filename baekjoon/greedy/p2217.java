package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class p2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max((i + 1) * rope[i], max);
        }

        System.out.println(max);
    }
}
