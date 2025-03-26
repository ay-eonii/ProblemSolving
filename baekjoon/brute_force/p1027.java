package baekjoon.brute_force;

/*
1. 아이디어
2. 시간복잡도
3. 자료구조
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1027 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(inputs[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i != 0) {
                count += compareLeft(heights, i);
            }
            if (i != n - 1) {
                count += compareRight(heights, i, n);
            }
            max = Math.max(count, max);
        }

        System.out.println(max);
    }

    private static int compareLeft(int[] heights, int i) {
        int count = 1;
        double slope = (heights[i] - heights[i - 1]) * 1.0;
        for (int j = i - 2; j >= 0; j--) {
            if ((slope * (j - i)) + (heights[i] * 1.0) < heights[j]) {
                count++;
            }
            slope = Math.min((heights[j] - heights[i]) * 1.0 / (j - i), slope);
        }

        return count;
    }

    private static int compareRight(int[] heights, int i, int n) {
        int count = 1;
        double slope = (heights[i + 1] - heights[i]) * 1.0;
        for (int j = i + 2; j < n; j++) {
            if ((slope * (j - i)) + (heights[i] * 1.0) < heights[j]) {
                count++;
            }
            slope = Math.max((heights[j] - heights[i]) * 1.0 / (j - i), slope);
        }
        return count;
    }
}
