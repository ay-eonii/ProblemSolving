import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장_많이_받은_선물 {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(friends[i], i);
        }

        int[][] record = new int[n][n];
        int[] diff = new int[n];
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int from = index.get(split[0]);
            int to = index.get(split[1]);

            diff[from]++;
            diff[to]--;
            record[from][to]++;
        }

        int[] recieve = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (record[i][j] > record[j][i]) {
                    recieve[i]++;
                }
                if (record[i][j] < record[j][i]) {
                    recieve[j]++;
                }

                if (record[i][j] == record[j][i]) {
                    // 같으면 지수 낮은 사람이 높은 사람한테
                    if (diff[i] > diff[j]) {
                        recieve[i]++;
                    }
                    if (diff[i] < diff[j]) {
                        recieve[j]++;
                    }
                }
            }
        }

        return Arrays.stream(recieve).max().getAsInt();
    }
}

// 두 사람 사이에 더 많은 선물을 준 사람: 다음 달에 선물을 하나 받습니다.
// 주고받지 않거나 주고받은 수가 많으면: 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
// 선물 지수: 준 선물 수 - 받은 선물 수
// 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.

// 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
