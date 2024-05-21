/* problem
레벨-L 버거는 햄버거번, 레벨-(L-1) 버거, 패티, 레벨-(L-1)버거, 햄버거번으로 이루어져 있다. (L ≥ 1)
레벨-1 버거는 'BPPPB', 레벨-2 버거는 'BBPPPBPBPPPBB'와 같이 생겼다.
상도가 햄버거의 아래 X장을 먹었을 때, 먹은 패티는 몇 장일까?
 */

package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16974 {

    private static long[] BURGERS;
    private static long[] PATTIES;
    private static int N;
    private static long X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        X = Long.parseLong(inputs[1]);
        if (X == 1) {
            System.out.println(0);
            return;
        }

        BURGERS = new long[N + 1];
        BURGERS[0] = 1;
        PATTIES = new long[N + 1];
        PATTIES[0] = 1;

        getBurger(N);
        getPatty(N);
        long count = countPatty(N, X);
        System.out.println(count);
    }

    private static long countPatty(int level, long eat) {
        long burgerSize = BURGERS[level];
        long middle = burgerSize / 2 + 1;

        if (level == 0) {
            if (eat == 0) {
                return 0;
            } else if (eat == 1) {
                return 1;
            }
        }

        if (eat == middle) { // 중간
            return middle / 2 + 1;
        } else if (eat == 0) { // 안먹음
            return 0;
        } else if (eat == burgerSize) { // 전부
            return PATTIES[level];
        } else if (eat < middle) { // 왼쪽
            return countPatty(level - 1, eat - 1);
        } else { // 오른쪽
            return (middle / 2 + 1) + countPatty(level - 1, eat - middle);
        }
    }

    private static long getBurger(int level) {
        if (BURGERS[level] != 0) {
            return BURGERS[level];
        }

        long lastBurger = getBurger(level - 1);
        return BURGERS[level] = (lastBurger * 2) + 3;
    }

    private static long getPatty(int level) {
        if (PATTIES[level] != 0) {
            return PATTIES[level];
        }

        long lastPatty = getPatty(level - 1);
        return PATTIES[level] = (lastPatty * 2) + 1;
    }
}

// strategy
// hamburgers[0, X] 중 패티 수

// 1=1, 1+1+1+1+1 = 5, 1+5+1+5+1 = 13, 1+13+1+13+1 = 29, 61
// burger[N] = (burger[N-1] * 2) + 3
// 1, 3, 7, 15, 31,
// patty[N] = burger[N-1] + 2

// 중간이라면? ex 2, 7
// patty[2] / 2 + 1 -> (burger[1]의 패티 + 1)
// 왼쪽이라면? ex 2, 3
// -> 1, 3 -> 중간
// patty[1] / 2 + 1
// 오른쪽이라면? ex 2, 8
// patty[2] / 2 + <1, 8-(burger[2]/2 + 1)>

// eat(0, burger[N]) <- start, 버거 크기
//    size/=2 <- 반-1 자르기
// if (size < X) ? eat(start, size) <- 반(미포함) 이전
// else ? eat(start + size, size) <- 반(포함) 이후

// 재귀 종료 조건 : start == X, size == 1
