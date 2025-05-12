import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 혼자_놀기의_달인 {
    private static boolean[] visited;

    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) {
                continue;
            }
            int count = open(cards, i, 0);
            counts.add(count);
        }

        Collections.sort(counts);

        if (counts.size() < 2) {
            return 0;
        }

        return counts.get(counts.size() - 1) * counts.get(counts.size() - 2);
    }

    public int open(int[] cards, int index, int count) {
        if (visited[index]) {
            return count;
        }

        visited[index] = true;
        int num = cards[index];
        return open(cards, num - 1, count + 1);
    }
}
