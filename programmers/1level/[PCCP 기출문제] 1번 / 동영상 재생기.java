class Solution {
	int[] video;
	int[] start;
	int[] end;
	int[] p;

	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		video = split(video_len);
		start = split(op_start);
		end = split(op_end);
		p = split(pos);

		for (String command : commands) {
			p = jumpOp(p);
			if (command.equals("next")) {
				p = next(p);
			} else {
				p = prev(p);
			}

		}
		p = jumpOp(p);

		return String.format("%02d:%02d", p[0], p[1]);
	}

	private int[] split(String time) {
		String[] split = time.split(":");
		int[] ret = new int[2];
		ret[0] = Integer.parseInt(split[0]);
		ret[1] = Integer.parseInt(split[1]);
		return ret;
	}

	private int[] next(int[] pos) {
		pos[1] += 10;

		if (pos[1] >= 60) {
			pos[0]++;
			pos[1] -= 60;
		}

		if ((pos[0] > video[0]) || (pos[0] >= video[0] && pos[1] > video[1])) {
			pos[0] = video[0];
			pos[1] = video[1];
		}

		return pos;
	}

	private int[] prev(int[] pos) {
		pos[1] -= 10;

		if (pos[1] > 0) {
			return pos;
		}

		if (pos[1] < 0) {
			pos[0]--;
			pos[1] += 60;
		}

		if (pos[0] < 0) {
			pos[0] = 0;
			pos[1] = 0;
		}
		return pos;
	}

	private int[] jumpOp(int[] pos) {
		if (((start[0] < pos[0]) || (start[0] <= pos[0] && start[1] <= pos[1])) && ((pos[0] < end[0]) || (
			pos[0] <= end[0] && pos[1] <= end[1]))) {
			pos[0] = end[0];
			pos[1] = end[1];
			return pos;
		}

		return pos;
	}
}

// 10초 전, 10초 후, 오프닝 건너뛰기
// ss >= 60 -> mm + 1 : 60 - ss
