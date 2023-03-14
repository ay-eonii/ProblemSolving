package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        int max = 1;
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = max < nums[i] ? nums[i] : max;
        }

        int[] counting = new int[max + 1];
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            counting[nums[i]]++;
        }

        for (int i = 1; i < max + 1; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            int value = nums[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        for (int r : result) {
            sb.append(r).append("\n");
        }

        System.out.println(sb);
    }
}
