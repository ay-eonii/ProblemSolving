/* problem
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> rawCards = List.of(br.readLine().split(" "));
        List<Integer> cards = new ArrayList<>();
        for (String rawCard : rawCards) {
            cards.add(Integer.parseInt(rawCard));
        }
        cards.sort((o1, o2) -> o1 - o2);

        int m = Integer.parseInt(br.readLine());
        List<String> rawNumbers = List.of(br.readLine().split(" "));
        List<Integer> numbers = new ArrayList<>();
        for (String rawNumber : rawNumbers) {
            numbers.add(Integer.parseInt(rawNumber));
        }

        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(findEndIndex(number, cards) - findStartIndex(number, cards))
                    .append(" ");
        }

        System.out.println(sb);
    }

    private static int findStartIndex(Integer number, List<Integer> cards) {
        int start = 0;
        int end = cards.size();
        while (start < end) {
            int pivot = (start + end) / 2;
            int mid = cards.get(pivot);
            if (number <= mid) {
                end = pivot;
            } else {
                start = pivot + 1;
            }
        }
        return start;
    }

    private static int findEndIndex(Integer number, List<Integer> cards) {
        int start = 0;
        int end = cards.size();
        while (start < end) {
            int pivot = (start + end) / 2;
            int mid = cards.get(pivot);
            if (number < mid) {
                end = pivot;
            } else {
                start = pivot + 1;
            }
        }
        return start;
    }
}
