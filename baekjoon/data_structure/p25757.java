package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p25757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		Game game = Game.of(inputs[1]);

		Set<String> players = new HashSet<>();
		for (int i = 0; i < N; i++) {
			players.add(br.readLine());
		}

		System.out.println(players.size() / game.members);
	}

	enum Game {
		Y(1),
		F(2),
		O(3);

		private final int members;

		Game(int members) {
			this.members = members;
		}

		static Game of(String game) {
			if ("Y".equals(game)) {
				return Y;
			}
			if ("F".equals(game)) {
				return F;
			}
			return O;
		}
	}
}

// strategy
// 윷놀이Y, 같은 그림 찾기F, 원카드O
//
