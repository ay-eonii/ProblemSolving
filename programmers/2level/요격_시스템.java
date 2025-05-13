import java.util.Arrays;

public class 요격_시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int prevS = targets[0][0];
        int prevE = targets[0][1];
        int count = 1;
        for (int i = 1; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];

            if (prevE <= s) {
                count++;
                prevS = s;
                prevE = e;
            } else {
                prevS = Math.min(s, prevS);
                prevE = Math.min(e, prevE);
            }
        }

        return count;
    }
}
