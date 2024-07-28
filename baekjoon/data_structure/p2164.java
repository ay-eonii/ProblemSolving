package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> cards = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			cards.add(i);
		}

		while (cards.size() != 1) {
			cards.remove();
			cards.add(cards.poll());
		}

		System.out.print(cards.poll());
	}
}

// strategy
// 제일 위에 카드 버리기
// 그다음 카드 제일 아래로 옮기기
// 반복
// queue
