class Solution {
	public String mergeAlternately(String word1, String word2) {
		String[] word1_split = word1.split("");
		String[] word2_split = word2.split("");

		int len = Math.max(word1.length(), word2.length());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (i < word1_split.length) {
				sb.append(word1_split[i]);
			}
			if (i < word2_split.length) {
				sb.append(word2_split[i]);
			}
		}

		return sb.toString();
	}
}
