/* problem
캐릭터의 전투력에 맞는 칭호를 출력하는 프로그램을 작성하자.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] titles = new String[n];
        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            titles[i] = inputs[0];
            powers[i] = Integer.parseInt(inputs[1]);
        }

        int[] characters = new int[m];
        for (int i = 0; i < m; i++) {
            characters[i] = Integer.parseInt(br.readLine());
        }

        int[] answers = new int[m];
        for (int i = 0; i < m; i++) {
            int min = 0;
            int max = n - 1;
            int answer = 0;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (characters[i] > powers[mid]) {
                    min = mid + 1;
                } else {
                    answer = mid;
                    max = mid - 1;
                }
            }
            answers[i] = answer;
        }

        StringBuilder sb = new StringBuilder();
        for (int answer : answers) {
            sb.append(titles[answer]).append(System.lineSeparator());
        }

        System.out.print(sb);
    }
}

// strategy
// 칭호, 전투력의 개수: 1 <= n <= 100,000
// 캐릭터 전투력 개수: 1 <= m <= 100,000

// 이분탐색 대상: 칭호 인덱스
// min = 0
// max = n - 1
// for (캐릭터 전투력)
//      while (min <= max)
//          if (캐릭터 전투력 > 칭호 전투력[mid])  -> 높은 칭호일수도 있음
//              min = mid + 1
//          else -> 현 칭호 or 낮은 칭호
//              answer = mid
//              max = mid - 1
