package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p3020 {
    static int N;
    static int H;
    static int[] TOP_OBSTACLES;
    static int[] BOTTOM_OBSTACLES;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        H = Integer.parseInt(inputs[1]);

        BOTTOM_OBSTACLES = new int[N / 2];
        TOP_OBSTACLES = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            BOTTOM_OBSTACLES[i] = Integer.parseInt(br.readLine());
            TOP_OBSTACLES[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(BOTTOM_OBSTACLES);
        Arrays.sort(TOP_OBSTACLES);

        int min = N;
        int count = 0;
        for (int i = 1; i < H + 1; i++) {
            int countWall = fly(i, BOTTOM_OBSTACLES) + fly(H - i + 1, TOP_OBSTACLES);
            if (min == countWall) {
                count++;
                continue;
            }
            if (countWall < min) {
                min = countWall;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }

    private static int fly(int h, int[] arr) {
        int min = 0;
        int max = N / 2;
        while (min < max) {
            int mid = (min + max) / 2;

            if (arr[mid] >= h) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return arr.length - max;
    }
}

// strategy
// 동굴의 길이 2 <= N <= 200,000 - 항상 짝수
// 동굴의 높이 2 <= H <= 500,000
// 이분탐색 대상 : 높이
// min = 2(석순), h(종유석)
// max = 석순, 종유석 max

// max 를 기준으로 각각 이분탐색
// 뿌리부터 이분탐색

// 석순 깨야 하는 경우 : mid < obstacles[i] (i % 2 == 0)
// 종유석 깨야 하는 경우: mid > obstacles[i] (i % 2 == 1)
// 최소한으로 파괴

//   |   |   |
//   |   |     *
//   |   | |
//   |     |   *
//   | |   |
//     |   |   *
// |   |   |

// 석순부터 종유석 끝까지
// 종유석부터 석순 끝까지

//    |   |   |   |   |   |  |     7
//    | | |   |   |   |   |  |     8
//    | |     | | | | | |  | |
//      |   | | | | |   |  |       8
//  |   |   |   |   |   |  |       7