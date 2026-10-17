import java.util.Arrays;

class Solution {
	public int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);

		int min = 0;
		int max = nums.length - 1;
		int answer = 0;
		while (min < max) {
			int sum = nums[min] + nums[max];
			if (sum == k) {
				answer++;
				min++;
				max--;
			} else if (sum < k) {
				min++;
			} else {
				max--;
			}
		}

		return answer;
	}
}

// sum < k => min ++
// sum > k => max ++
