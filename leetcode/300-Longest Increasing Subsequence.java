package leetcode;

import java.util.Arrays;

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int answer = 1;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(dp[i], answer);
        }

        return answer;
    }
}
