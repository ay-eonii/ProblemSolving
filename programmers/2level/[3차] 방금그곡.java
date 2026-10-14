class Solution {
	public String solution(String m, String[] musicinfos) {
		int size = musicinfos.length;
		String answer = "";
		int runningTime = 0;

		for (int i = 0; i < size; i++) {
			String[] info = musicinfos[i].split(",");
			String title = info[2];
			String melody = info[3];
			int musicLen = info[3].replace("#", "").split("").length;

			int minutes = getMinutes(info[0], info[1]);

			String repeat = melody;
			if (minutes / musicLen >= 1) {
				repeat = melody.repeat(minutes / musicLen + 1);
			}

			int count = 0;
			int diff = minutes % musicLen;
			int up = 0;
			for (int j = repeat.length() - 1; j >= 0; j--) {
				if (repeat.charAt(j) == '#') {
					up++;
					continue;
				}
				count++;
				if (diff == musicLen - count) {
					break;
				}
			}
			repeat = repeat.substring(0, repeat.length() - count - up);

			int next = 0;
			if (!repeat.contains(m)) {
				continue;
			}

			int index = repeat.indexOf(m);
			while (index != -1) {
				if (repeat.length() == index + m.length()) {
					if (runningTime < minutes) {
						answer = title;
						runningTime = minutes;
					}
					break;
				}
				if (repeat.length() > index + m.length() && repeat.charAt(index + m.length()) != '#') {
					if (runningTime < minutes) {
						answer = title;
						runningTime = minutes;
					}
					break;
				}
				next++;
				index = repeat.indexOf(m, next);
			}
		}

		return "".equals(answer) ? "(None)" : answer;
	}

	private int getMinutes(String start, String end) {
		String[] s = start.split(":");
		int startHour = Integer.parseInt(s[0]);
		int startMinutes = Integer.parseInt(s[1]);

		String[] e = end.split(":");
		int endHour = Integer.parseInt(e[0]);
		int endMinutes = Integer.parseInt(e[1]);

		if (startMinutes <= endMinutes) {
			return (endHour - startHour) * 60 + endMinutes - startMinutes;
		}
		return (endHour - 1 - startHour) * 60 + 60 + endMinutes - startMinutes;
	}

}
