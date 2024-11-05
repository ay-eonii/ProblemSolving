package baekjoon.implementation;

/*
1. 아이디어
- Queue
2. 시간복잡도
- 10,000 * 1,000 = 10,000,000
3. 자료구조
- Queue
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p31797 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Hand[] hands = new Hand[M * 2];
        int playerOrder = 1;
        for (int i = 0; i < M * 2; i += 2) {
            inputs = br.readLine().split(" ");
            hands[i] = new Hand(Integer.parseInt(inputs[0]), playerOrder);
            hands[i + 1] = new Hand(Integer.parseInt(inputs[1]), playerOrder);
            playerOrder++;
        }
        Arrays.sort(hands);

        int loser = N % (M * 2) == 0 ? M * 2 - 1 : N % (M * 2) - 1;

        System.out.print(hands[loser].player);
    }

    static class Hand implements Comparable<Hand> {
        int hand;
        int player;

        public Hand(int hand, int player) {
            this.hand = hand;
            this.player = player;
        }

        @Override
        public int compareTo(Hand that) {
            return this.hand - that.hand;
        }
    }
}
