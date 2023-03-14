package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[5];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
            sum += nums[i];
        }

        minSelectionSorting(nums);

        System.out.println((int) sum / 5);
        System.out.println(nums[nums.length / 2]);
    }

    private static void minSelectionSorting(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                min = (nums[min] > nums[j]) ? j : min;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
