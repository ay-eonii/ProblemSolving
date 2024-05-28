package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p3649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10_000_000;

            int n = Integer.parseInt(br.readLine());
            int[] blocks = new int[n];
            for (int i = 0; i < n; i++) {
                blocks[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(blocks);

            int left = 0;
            int right = n - 1;
            while (left < right) {
                int sum = blocks[left] + blocks[right];
                if (sum == x) {
                    break;
                }

                if (sum > x) {
                    right--;
                } else {
                    left++;
                }
            }

            if (left < right) {
                System.out.println("yes " + blocks[left] + " " + blocks[right]);
            } else {
                System.out.println("danger");
            }
        }
    }
}

// strategy
// 레고 조각: 나노미터
// 블록 <= 10 cm (100,000,000 nm)
// 너비 20cm -> 2,000,000,000 nm -> int

// 1cm == 10,000,000 nm
// 구멍과 (레고 합 / 10,000,000) 비교
//
