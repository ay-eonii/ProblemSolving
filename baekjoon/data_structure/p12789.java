package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p12789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] orders = br.readLine().split(" ");

		Stack<Integer> line1 = new Stack<>();
		Stack<Integer> line2 = new Stack<>();
		for (int i = orders.length - 1; i >= 0; i--) {
			line1.add(Integer.parseInt(orders[i]));
		}

		for (int i = 1; i <= n; i++) {
			if (line1.contains(i)) {
				while (line1.peek() != i) {
					line2.add(line1.pop());
				}
				line1.pop();
			} else {
				if (line2.pop() != i) {
					System.out.print("Sad");
					return;
				}
			}
		}
		System.out.print("Nice");
	}
}

// strategy
// 스택 2개
// 1. 1번 스택 -> 입력 반대 순서로 push
// 2. 현재 순서가 나올때까지 현재 순서가 있는 스택 pop 후 다른 스택에 push
// 3. 순서 나오면 pop
// 4. 승환 번호까지 반복
// 5. 다른 스택에서 원래 스택으로 갈 수 없음
// 승환이가 간식 받을 수 있으면 Nice
// 못받으면 Sad
