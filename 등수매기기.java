// 내 풀이
import java.util.Arrays;
import java.util.Collections;

class Solution {

  public int[] solution(int[][] score) {
    double[] average = new double[score.length];
    for (int i = 0; i < score.length; i++) {
      average[i] = (double) (score[i][0] + score[i][1]) / 2;
    }

    Double[] averageSort = Arrays
      .stream(average)
      .boxed()
      .toArray(Double[]::new);
    Arrays.sort(averageSort, Collections.reverseOrder());
    int[] answer = new int[score.length];

    for (int i = 0; i < score.length; i++) {
      answer[i] = Arrays.asList(averageSort).indexOf(average[i]) + 1;
    }
    return answer;
  }

}

// 다른 사람 풀이
import java.util.*;

class Solution {

  public int[] solution(int[][] score) {
    List<Integer> scoreList = new ArrayList<>();
    for (int[] t : score) {
      scoreList.add(t[0] + t[1]);
    }
    scoreList.sort(Comparator.reverseOrder());

    int[] answer = new int[score.length];
    for (int i = 0; i < score.length; i++) {
      answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
    }
    return answer;
  }
}
