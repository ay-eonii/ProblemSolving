package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2852 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int score1 = 0, score2 = 0;
		int time1 = 0, time2 = 0, prevTime = 0;

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int winTeam = Integer.parseInt(input[0]);
			String winTime = input[1];

			String[] time = winTime.split(":");
			int intTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
			int result = intTime - prevTime;
			prevTime = intTime;

			if (score1 > score2) {
				time1 += result;
			} else if (score1 < score2) {
				time2 += result;
			}

			if (winTeam == 1) {
				score1++;
			} else {
				score2++;
			}
		}

		int intTime = 48 * 60;
		int result = intTime - prevTime;
		if (score1 > score2) {
			time1 += result;
		} else if (score1 < score2) {
			time2 += result;
		}

		System.out.println(toTime(time1));
		System.out.println(toTime(time2));
	}

	static String toTime(int time) {
		String ret = "";
		ret += String.format("%02d", time / 60);
		ret += ":";
		ret += String.format("%02d", time % 60);
		return ret;
	}
}
