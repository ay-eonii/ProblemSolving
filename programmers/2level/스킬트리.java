class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		char[] skills = skill.toCharArray();
		int[] levels = new int[26];
		for (int i = 0; i < skills.length; i++) {
			levels[skills[i] - 'A'] = i + 1;
		}

		for (String s : skill_trees) {
			char[] a = s.toCharArray();

			int now = 0;
			boolean available = true;
			for (int i = 0; i < a.length; i++) {
				int l = levels[a[i] - 'A'];
				if (now >= l) {
					continue;
				}
				if (l - now > 1) {
					available = false;
					break;
				}
				now = l;
			}

			if (available) {
				answer++;
			}
		}

		return answer;
	}
}

// 가능한 스킬트리 개수 리턴
