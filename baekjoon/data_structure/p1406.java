package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class p1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		int n = Integer.parseInt(br.readLine());

		List<Character> list = new LinkedList<>();
		for (char t : text) {
			list.add(t);
		}

		ListIterator<Character> iterator = list.listIterator();
		while (iterator.hasNext()) {
			iterator.next();
		}

		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			switch (command) {
				case "L":
					if (iterator.hasPrevious()) {
						iterator.previous();
					}
					break;
				case "D":
					if (iterator.hasNext()) {
						iterator.next();
					}
					break;
				case "B":
					if (iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}
					break;
				default:
					char s = command.charAt(2);
					iterator.add(s);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			sb.append(c);
		}

		System.out.print(sb);
	}
}
