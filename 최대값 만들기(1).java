import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
			int size = numbers.length;
			Arrays.sort(numbers);

			return numbers[size - 1] * numbers[size - 2];
    }
}
