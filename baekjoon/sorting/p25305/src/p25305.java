import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        int exam = Integer.parseInt(info[0]);
        int cut = Integer.parseInt(info[1]);

        String[] scoreArr = bf.readLine().split(" ");

        int[] scores = new int[exam];
        int[] sortScores = new int[exam];
        for (int i = 0; i < exam; i++) {
            scores[i] = Integer.parseInt(scoreArr[i]);
        }

        mergeSorting(scores, sortScores, 0, exam - 1);

        System.out.println(scores[cut - 1]);
    }

    private static void mergeSorting(int[] scores, int[] sortScores, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSorting(scores, sortScores, start, mid);
            mergeSorting(scores, sortScores, mid + 1, end);

            int frontStart = start;
            int backStart = mid + 1;
            int sortIndex = frontStart;
            while (frontStart <= mid || backStart <= end) {
                if (backStart > end || (frontStart <= mid && scores[frontStart] > scores[backStart])) {
                    sortScores[sortIndex++] = scores[frontStart++];
                } else {
                    sortScores[sortIndex++] = scores[backStart++];
                }
            }

            for (int i = start; i <= end; i++) {
                scores[i] = sortScores[i];
            }
        }
    }
}
