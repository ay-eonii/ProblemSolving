import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int rank = map.get(calling);

            String beforePlayer = players[rank - 1];

            players[rank - 1] = calling;
            players[rank] = beforePlayer;

            map.put(calling, rank - 1);
            map.put(beforePlayer, rank);
        }

        return players;
    }
}
