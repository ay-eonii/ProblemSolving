import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 광물_캐기 {

    public int solution(int[] picks, String[] minerals) {
        List<int[]> list = new ArrayList<>();

        int picksCount = picks[0] + picks[1] + picks[2];

        int length = Math.min(picksCount * 5, minerals.length);
        for (int i = 0; i < length; i += 5) {
            int[] count = new int[3];
            for (int j = i; j < Math.min(i + 5, length); j++) {
                if ("diamond".equals(minerals[j])) {
                    count[0]++;
                } else if ("iron".equals(minerals[j])) {
                    count[1]++;
                } else {
                    count[2]++;
                }
            }
            list.add(count);
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] mCount = list.get(i);

            if (picks[0] > 0) { // 다이아 곡괭이
                answer += mCount[0] + mCount[1] + mCount[2];
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이
                answer += 5 * mCount[0];
                answer += mCount[1] + mCount[2];
                picks[1]--;
            } else {
                answer += 25 * mCount[0];
                answer += 5 * mCount[1];
                answer += mCount[2];
                picks[2]--;
            }
        }

        return answer;
    }
}
