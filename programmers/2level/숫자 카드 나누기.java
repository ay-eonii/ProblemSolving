import java.util.Arrays;

class Solution {
	public int solution(int[] arrayA, int[] arrayB) {
		// 1. 최소 구하기 (min)
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		int minA = arrayA[0];
		int minB = arrayB[0];

		int answer = go(minA, arrayA, arrayB);
		if (answer == 0) {
			return go(minB, arrayB, arrayA);
		}

		return Math.max(answer, go(minB, arrayB, arrayA));
	}

	private int go(int min, int[] arrayA, int[] arrayB) {
		for (int num = 1; num <= min / 2; num++) {
			if (min % num != 0) {
				continue;
			}
			int tmp = min / num;
			if (min % tmp != 0) {
				continue;
			}
			boolean ok = true;
			for (int i = 1; i < arrayA.length; i++) {
				if (arrayA[i] % tmp != 0) {
					ok = false;
					break;
				}
			}

			if (ok) {
				for (int i = 0; i < arrayB.length; i++) {
					if (arrayB[i] % tmp == 0) {
						ok = false;
						break;
					}
				}
			}

			if (ok) {
				return tmp;
			}
		}
		return 0;
	}
}

// 8:03
// 숫자가 하나씩 적힌 카드 절반 나눠 가지고 가장 큰 양의 정수 구하기 (조건 1 || 조건 2)
//  조건1. 철수카드 나누기 가능. 영희카드 나누기 불가능
//  조건2. 철수카드 나누기 가능. 철수카드 나누기 불가능
// 둘 다 만족하지 않으면 0

// 철수카드 최대공약수 구하기 -> 영희카드 나눠보기
// 영희카드 최대공약수 구하기 -> 철수카드 나눠보기

// 최소보다 작을 수 밖에
// 정렬하기
// 최소의 약수..

// [10,17]
// 10 : [0, 7]
// 한쪽만 0 -> 안됨

// [5, 20]
// 5: [0, 0]
// 둘다 0 -> 된다

// [14, 35, 119]
// 14 : [0, 7, ?] (14/1)
// 7 : [0, 0, 0] (14/2)

// [18, 30, 102]
// 18 : [0, 12, 16] (18/1)
// 9 : [0, 3, ?] (18/2)
// 6 : [0, 0, 0] (18/3)

// 1. 최소 구하기 (min)
// 2. min/1, min/2, min/3... (min/(min/2)+1 으로 나눠보기 (min % ? == 0 인경우)
// 3. 중간에 나머지 전부 0이라면, 다른 배열 다 안 나눠지는 지 확인
// 4. 반대로 해보기
