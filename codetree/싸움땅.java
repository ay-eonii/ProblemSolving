import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {-1, 0, 1, 0};

	private static int n;
	private static int[] answer;
	private static Player[] players;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 격자 크기
		int m = Integer.parseInt(st.nextToken()); // 플레이어 수
		int k = Integer.parseInt(st.nextToken()); // 라운드 수

		Space[][] space = new Space[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int t = Integer.parseInt(st.nextToken());
				space[i][j] = new Space(t);
			}
		}

		players = new Player[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1; // 행
			int x = Integer.parseInt(st.nextToken()) - 1; // 열
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			players[i] = new Player(x, y, d, s, i);
			space[y][x].join(i);
		}

		answer = new int[m];
		while (k > 0) {
			for (int i = 0; i < m; i++) {
				// System.out.println("k:" + k + " player:"+i);
				// 1. 이동()
				move(players[i], space);

				int x = players[i].x;
				int y = players[i].y;
				if (space[y][x].players.size() == 1) {
					// 2. 총줍기()
					pick(players[i], space);
				} else {
					// 3. 싸우기()
					fight(players[i], space);
				}
				// print(space);
			}
			k--;
		}

		StringBuilder sb = new StringBuilder();
		for (int a : answer) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}

	private static void fight(Player player, Space[][] space) {
		Space location = space[player.y][player.x];
		if (location.players.size() < 2) {
			return;
		}

		Player p1 = players[location.players.get(0)];
		Player p2 = players[location.players.get(1)];

		Player winner;
		Player loser;
		if (p1.s + p1.t < p2.s + p2.t) {
			winner = p2;
			loser = p1;
		} else if (p1.s + p1.t > p2.s + p2.t) {
			winner = p1;
			loser = p2;
		} else {
			if (p1.s < p2.s) {
				winner = p2;
				loser = p1;
			} else {
				winner = p1;
				loser = p2;
			}
		}

		// 이긴사람 포인트
		int point = Math.abs((p1.t + p1.s) - (p2.s + p2.t));
		answer[winner.n] += point;

		// 진사람 총두고 떠나기
		loserMove(loser, space);

		// 이긴사람 총고르기
		pick(winner, space);
	}

	private static void loserMove(Player loser, Space[][] space) {
		Space location = space[loser.y][loser.x];

		location.add(loser.t);
		loser.t = 0;

		int d = loser.d;
		int nx = loser.x + dx[d];
		int ny = loser.y + dy[d];

		while (nx < 0 || nx >= n || ny < 0 || ny >= n || space[ny][nx].players.size() != 0) {
			// 오른쪽 90도 회전
			loser.d = (loser.d + 1) % 4;
			nx = loser.x + dx[loser.d];
			ny = loser.y + dy[loser.d];
		}

		loser.x = nx;
		loser.y = ny;
		location.leave(loser.n);
		space[ny][nx].join(loser.n);

		// 무기고르기
		pick(loser, space);
	}

	private static Player findWinner(Player p1, Player p2) {
		if (p1.s + p1.t < p2.s + p2.t) {
			return p2;
		} else if (p1.s + p1.t > p2.s + p2.t) {
			return p1;
		}
		if (p1.s < p2.s) {
			return p2;
		}
		return p1;
	}

	private static void pick(Player player, Space[][] space) {
		int x = player.x;
		int y = player.y;

		int picked = space[y][x].changeTool(player.t);
		if (picked != 0) {
			player.t = picked;
		}
	}

	private static void move(Player player, Space[][] space) {
		Space location = space[player.y][player.x];
		int d = player.d;
		int nx = player.x + dx[d];
		int ny = player.y + dy[d];

		if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
			player.d = (d + 2) % 4;
			d = player.d;
			nx = player.x + dx[d];
			ny = player.y + dy[d];
		}

		player.x = nx;
		player.y = ny;

		location.leave(player.n);
		space[ny][nx].join(player.n);
	}

	private static void print(Space[][] space) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Space s = space[i][j];
				System.out.print("[");
				for (int t : s.tools) {
					System.out.print(t + " ");
				}
				System.out.print("]");
			}
			System.out.println();
		}
	}

	public static class Space {
		PriorityQueue<Integer> tools = new PriorityQueue<>((o1, o2) -> o2 - o1);
		List<Integer> players = new ArrayList<>();

		public Space(int t) {
			if (t != 0) {
				tools.add(t);
			}
		}

		public int changeTool(int t) {
			if (tools.isEmpty()) {
				return 0;
			}
			if (tools.peek() > t) {
				tools.add(t);
				return tools.poll();
			}

			return 0;
		}

		public void join(int player) {
			players.add(player);
		}

		public void leave(int player) {
			players.remove((Integer)player);
		}

		public void add(int t) {
			tools.add(t);
		}
	}

	public static class Player {
		int x;
		int y;
		int d;
		int s;
		int t;
		int n;

		public Player(int x, int y, int d, int s, int n) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
			this.t = 0;
			this.n = n;
		}
	}
}

