/* problem
 과일을 두 종류 이하로 사용한 탕후루 중에서,
 과일의 개수가 가장 많은 탕후루의 과일 개수를 구하세요.
 */

package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p30804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fruits = new int[n];
        int[] count = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int kind = 0;
        while (right < n) {
            if (count[fruits[right]] == 0) {
                kind++;
            }
            count[fruits[right]]++;
            right++;

            if (kind > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] == 0) {
                    kind--;
                }
                left++;
            }
        }
        System.out.println(right - left);
    }
}

// strategy
// 막대의 앞에서 a개, 막대의 뒤에서 b개 빼기

