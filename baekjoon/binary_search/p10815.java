/* problem
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 */

package baekjoon.binary_search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class p10815 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        Arrays.sort(cards);

        int m = scanner.nextInt();

        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = scanner.nextInt();
        }

        // -10 2 3 6 10
        int[] answers = new int[m];
        for (int i = 0; i < m; i++) {
            int min = 0;
            int max = n;
            while (min < max) {
                int mid = (min + max) / 2;
                if (cards[mid] == targets[i]) {
                    answers[i]++;
                    break;
                }
                if (targets[i] < cards[mid]) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int answer : answers) {
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
}

// strategy
// 가진 카드 수 n : int
// 카드 숫자 card[i] : int 중복x
// 비교 카드 수 m : int
// 비교 카드 숫자 compareCard[i] : int 중복x

// 상근이가 비교 카드 숫자를 가지고 있는지(1,0) 확인
// 상근이 카드 정렬
// 비교 카드 순회하면서 상근이 카드 이분탐색
