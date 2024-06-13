package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p16434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int atk = Integer.parseInt(inputs[1]);

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Room room = new Room(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            rooms.add(room);
        }

        long min = 1;
        long max = Long.MAX_VALUE - 1;
        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long hp = mid;
            long gameAtk = atk;
            for (Room room : rooms) {
                if (room.existsMonster()) {
                    long attackCount = room.hp / gameAtk; // 1,000,000
                    if (room.hp % gameAtk != 0) {
                        attackCount++;
                    }
                    hp -= (attackCount - 1) * room.atk;
                    if (hp <= 0) {
                        break;
                    }
                } else {
                    hp = Math.min(mid, hp + room.hp);
                    gameAtk += room.atk;
                }
            }
            if (hp <= 0) { // 체력 올리기
                min = mid + 1;
            } else {
                answer = mid;
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static class Room {
        int number;
        int atk;
        int hp;

        public Room(int number, int atk, int hp) {
            this.number = number;
            this.hp = hp;
            this.atk = atk;
        }

        public boolean existsMonster() {
            return number == 1;
        }
    }
}

// strategy
// 이분탐색 대상 : 체력
