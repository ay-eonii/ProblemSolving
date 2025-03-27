package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[1_001];
        int left = 1_000;
        int right = 0;
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int index = Integer.parseInt(inputs[0]);
            heights[index] = Integer.parseInt(inputs[1]);
            left = Math.min(index, left);
            right = Math.max(index, right);
        }

        int answer = 0;
        int current = 0;
        while (left <= right) {
            while (heights[left] == 0) {
                left++;
            }
            while (heights[right] == 0) {
                right--;
            }

            int width = right - left + 1;
            if (heights[left] < heights[right]) {
                if (current < heights[left]) {
                    answer += (heights[left] - current) * width;
                    current = heights[left];
                }
                left++;
            } else if (heights[left] > heights[right]) {
                if (current < heights[right]) {
                    answer += (heights[right] - current) * width;
                    current = heights[right];
                }
                right--;
            } else {
                if (current < heights[right]) {
                    answer += (heights[right] - current) * width;
                    current = heights[right];
                }
                left++;
                right--;
            }
        }

        System.out.println(answer);
    }
}
