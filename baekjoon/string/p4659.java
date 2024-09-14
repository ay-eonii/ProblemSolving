package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringJoiner;

public class p4659 {

	public static final String LAST_COMMAND = "end";
	public static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');
	public static final List<Character> EXCLUDE = List.of('e', 'o');
	private static final String HIGH_QUALITY_COMMENT_FORMAT = "<%s> is acceptable.";
	private static final String LOW_QUALITY_COMMENT_FORMAT = "<%s> is not acceptable.";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringJoiner answer = new StringJoiner("\n");
		String password;
		while (!LAST_COMMAND.equals(password = br.readLine())) {
			char[] chars = password.toCharArray();
			boolean hasVowel = false;
			int vowelCount = 0;
			int consonantCount = 0;
			char before = chars[0];
			for (int i = 0; i < chars.length; i++) {
				hasVowel = hasVowel(hasVowel, chars, i);
				if (VOWELS.contains(chars[i])) { // 모음임
					vowelCount++;
					consonantCount = 0;
				} else {
					vowelCount = 0;
					consonantCount++;
				}
				if (hasSequenceOverThree(vowelCount, consonantCount, answer, password))
					break;
				if (hasSequenceChar(i, chars, before, answer, password)) {
					break;
				}
				before = chars[i];
				if (i == chars.length - 1) {
					if (!hasVowel) {
						answer.add(String.format(LOW_QUALITY_COMMENT_FORMAT, password));
					} else {
						answer.add(String.format(HIGH_QUALITY_COMMENT_FORMAT, password));
					}
				}
			}

		}

		System.out.println(answer);
	}

	private static boolean hasSequenceChar(int i, char[] chars, char before, StringJoiner answer, String password) {
		if (i != 0 && !EXCLUDE.contains(chars[i]) && chars[i] == before) {
			answer.add(String.format(LOW_QUALITY_COMMENT_FORMAT, password));
			return true;
		}
		return false;
	}

	private static boolean hasSequenceOverThree(int vowelCount, int consonantCount, StringJoiner answer,
		String password) {
		if (vowelCount == 3 || consonantCount == 3) { // 3 연속
			answer.add(String.format(LOW_QUALITY_COMMENT_FORMAT, password));
			return true;
		}
		return false;
	}

	private static boolean hasVowel(boolean hasVowel, char[] chars, int i) {
		if (!hasVowel) { // 모음 없음
			if (VOWELS.contains(chars[i])) { // 모음있음
				hasVowel = true;
			}
		}
		return hasVowel;
	}
}

// strategy
// 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
// 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
// 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
