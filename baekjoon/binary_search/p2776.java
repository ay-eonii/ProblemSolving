/* problem
연종이 하루 동안 본 정수들을 모두 ‘수첩1’에 적어 놓았다. 연종이 봤다고 주장하는 수 들을 ‘수첩2’에 적어 두었다.
‘수첩2’에 적혀있는 순서대로, 각각의 수에 대하여, ‘수첩1’에 있으면 1을, 없으면 0을 출력하는 프로그램을 작성해보자.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] facts = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                facts[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(facts);

            int m = Integer.parseInt(br.readLine());
            int[] memeories = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                memeories[j] = Integer.parseInt(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                int min = 0;
                int max = n - 1;
                int mid = 0;
                while (min <= max) {
                    mid = (min + max) / 2;
                    if (memeories[j] == facts[mid]) {
                        break;
                    }
                    if (memeories[j] > facts[mid]) {
                        min = mid + 1;
                    } else {
                        max = mid - 1;
                    }
                }
                if (memeories[j] == facts[mid]) {
                    sb.append(1).append(System.lineSeparator());
                } else {
                    sb.append(0).append(System.lineSeparator());
                }
            }
            System.out.print(sb);
        }
    }
}
