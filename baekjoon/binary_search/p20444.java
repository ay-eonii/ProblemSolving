/*
색종이를 자를 때는 다음과 같은 규칙을 따른다.
- 색종이는 직사각형이며, 색종이를 자를 때는 한 변에 평행하게 자른다.
- 자르기 시작했으면, 경로 상의 모든 색종이를 자를 때까지 멈추지 않는다.
- 이미 자른 곳을 또 자를 수 없다.

하나의 색종이를 정확히 n번의 가위질로 k개의 색종이 조각으로 만들 수 있는지 판단하는 코드를 작성하시오.
 */

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p20444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        long k = Long.parseLong(inputs[1]);
        if ((n == 1 && k != 2) || n >= k) {
            System.out.println("NO");
            return;
        }

        long min = 0;
        long max = n / 2;
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = (mid + 1) * (n - mid + 1);
            if (count == k) {
                System.out.println("YES");
                System.exit(0);
            }

            if (count < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println("NO");
    }
}

// strategy
// n번의 가위질로 k개의 색종이 조각 만들기
// n : int
// k : long

// 세로, 가로 번갈아가면서 자르기
// 1 2 4 6 9
// 1*1, 1*2, 2*2, 2*3, 3*3(4번자름) ; 가로 * 세로
// 0번(1) * 4번(5)
// 0*4, 1*3, 2*2
// while (가로 <= 세로)
// 가로 + 세로 == n
// 가로 * 세로 == k
//
