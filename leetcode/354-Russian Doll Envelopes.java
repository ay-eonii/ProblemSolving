package leetcode;

import java.util.Arrays;

class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] height) {

        int length = 0;
        int[] top = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            int target = height[i];

            int left = 0;
            int right = length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > target) {
                    right = mid - 1;
                } else if (top[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left == length) {
                length++;
            }
            top[left] = target;
        }

        return length;
    }
}

// 너비 오름차순 정렬, 높이 내림차순 정렬
// 높이에서 최장 증가 부분 순열
// 시간초과 -> 이분탐색
