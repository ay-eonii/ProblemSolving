package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int k = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        int[] cables = new int[k];
        for (int i = 0; i < k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cables);

        long min = 0;
        long max = cables[k - 1] + 1L;
        while (min < max) {
            long average = (min + max) / 2;
            long count = 0;
            for (int cable : cables) {
                count += (cable / average);
            }

            if (count < n) { // 더 작게 잘라야함
                max = average;
            } else { // 더 크게 잘라야함
                min = average + 1;
            }
        }
        System.out.println(min - 1);
    }
}

// strategy
// 중간 길이((802 + 457) / 2 = 629)로 자른다
// count < n ? max = mid
// count >= n ? min = mid + 1
