package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int h = Integer.parseInt(inputs[0]);
        int w = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int[] height = new int[w];
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(inputs[i]);
        }

        boolean[][] blocks = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i >= h - height[j]) {
                    blocks[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < h; i++) {
            int left = 0;
            int right = 1;
            while (right < w) {
                if (blocks[i][left] && blocks[i][right]) {
                    answer += right - left - 1;
                    left = right;
                }

                while ((left < w && !blocks[i][left]) || (left + 1 < w && blocks[i][left + 1])) {
                    left++;
                    right = left;
                }
                right++;
            }
        }

        System.out.println(answer);
    }
}
