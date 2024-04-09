package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(trees);
        long min = 1;
        long max = trees[n - 1] + 1L;

        while (min < max) {
            long height = (min + max) / 2;
            long sum = 0;
            for (int tree : trees) {
                if (tree >= height) {
                    sum += (tree - height);
                }
            }

            if (sum < m) {
                max = height;
            } else {
                min = height + 1;
            }
        }

        System.out.println(min - 1);
    }
}

// strategy
// 적어도 M 미터를 충족하는 절단기에 설정할 수 있는 높이의 최댓값
// while (최단높이 < 최장높이)
// 설정 높이(H) = (0 + 최장높이) / 2
// 들고 갈 나무의 합(S) = N[i] - H
// if (S > M) ? 최단높이 = H + 1 : 최장높이 = H
// return 최단높이 - 1
