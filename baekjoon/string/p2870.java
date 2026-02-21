package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p2870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<BigInteger> answer = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			String[] split = input.split("[a-z]+");
			for (String s : split) {
				if (!s.isEmpty()) {
					answer.add(new BigInteger(s));
				}
			}
		}

		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		for (BigInteger i : answer) {
			sb.append(i + "\n");
		}

		System.out.print(sb);
	}
}
