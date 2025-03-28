package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p20006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int players = Integer.parseInt(inputs[0]);
        int limit = Integer.parseInt(inputs[1]);

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            inputs = br.readLine().split(" ");
            Player player = new Player(Integer.parseInt(inputs[0]), inputs[1]);
            boolean flag = false;
            for (Room room : rooms) {
                if (room.canJoin(player.level)) {
                    room.join(player);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                rooms.add(new Room(player, limit));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room.isFull() ? "Started!\n" : "Waiting!\n");
            room.sortPlayers();
            for (Player player : room.players) {
                sb.append(String.format("%d %s\n", player.level, player.name));
            }
        }

        System.out.println(sb);
    }

    static class Player implements Comparable<Player> {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }

    static class Room {
        int minLevel;
        int maxLevel;
        int limit;
        List<Player> players;

        public Room(Player player, int limit) {
            this.minLevel = player.level - 10;
            this.maxLevel = player.level + 10;
            this.limit = limit;
            ArrayList<Player> players = new ArrayList<>();
            players.add(player);
            this.players = players;
        }

        public void sortPlayers() {
            Collections.sort(players);
        }

        public boolean isFull() {
            return players.size() == limit;
        }

        public boolean canJoin(int level) {
            return minLevel <= level && level <= maxLevel && players.size() < limit;
        }

        public void join(Player player) {
            players.add(player);
        }
    }
}
