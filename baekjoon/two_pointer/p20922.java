package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] nums = new int[n];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int[] count = new int[100_001];
        int max = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (count[nums[right]] <= k) {
                count[nums[right]]++;
            }

            while (count[nums[right]] > k) {
                count[nums[left]]--;
                left++;
            }

            max = Math.max(right - left + 1, max);
        }

        System.out.println(max);
    }
}
