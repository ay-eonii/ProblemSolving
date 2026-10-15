import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int n, long k) {
		List<Integer> nums = new ArrayList<>();
		long factorial = 1;
		for (int i = 1; i <= n; i++) {
			nums.add(i);
			factorial *= i;          // 반복이 끝나면 n!
		}

		int[] answer = new int[n];
		k--;

		// 각 자리 숫자 구하기
		for (int i = 0; i < n; i++) {
			factorial /= (n - i); // (n-1)!
			int idx = (int)(k / factorial); // idx 번째 묶음
			answer[i] = nums.remove(idx); // 확정
			k %= factorial;
		}

		return answer;
	}
}

// 사람을 나열 하는 방법을 사전순으로 나열했을 때 k 번째 방법
