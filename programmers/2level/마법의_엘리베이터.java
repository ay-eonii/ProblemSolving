class Solution {
	public int solution(int storey) {
		int answer = 0;

		while (storey != 0) {
			int move = countMove(storey);
			answer += Math.abs(move);

			storey += move;
			storey /= 10;
		}

		return answer;
	}

	public int countMove(int number) {
		int units = number % 10;
		int tenUnits = number / 10 % 10;
		if (units == 5 && tenUnits >= 5) {
			return 5;
		}

		if (units == 0) {
			return 0;
		}
		if (units <= 5) {
			return -units;
		}
		return 10 - units;
	}
}
