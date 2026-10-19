import java.util.Stack;

class Solution {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < asteroids.length; i++) {
			int tmp = asteroids[i];
			while (!stack.isEmpty() && tmp != 0 && canCollide(stack.peek(), tmp)) {
				if (Math.abs(stack.peek()) < Math.abs(tmp)) {
					stack.pop();
					continue;
				}

				if (Math.abs(stack.peek()) == Math.abs(tmp)) {
					stack.pop();
				}
				tmp = 0;
				break;
			}

			if (tmp == 0) {
				continue;
			}

			if (stack.isEmpty()) {
				stack.push(asteroids[i]);
				continue;
			}

			if (!canCollide(stack.peek(), tmp)) {
				stack.push(asteroids[i]);
				continue;
			}

		}

		int len = stack.size();
		int[] answer = new int[len];
		while (!stack.isEmpty()) {
			len--;
			answer[len] = stack.pop();
		}

		return answer;
	}

	public boolean canCollide(int a, int b) {
		return a > 0 && b < 0;
	}
}

// 양수: 오른쪽
// 음수: 왼쪽
// 만나면 작은거 충돌, 같으면 둘다 충돌
// 같은 방향은 안만남

// stack
// 1. empty -> push
// 2. 부호같음 (peek(), arr[i]) -> push
// 3. 부호다름 (peek(), arr[i]) -> abs(peek()) vs abs(arr[i])  ~ while
// 3-1. abs(peek()) > abs(arr[i]) -> continue;
// 3-2. abs(peek()) < abs(arr[i]) -> pop();
// 3-3. abs(peek()) > abs(arr[i]) -> pop; continue;
