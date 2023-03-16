package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(str[0]);
            nums[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        for (int[] num : nums) {
            for (int n : num) {
                sb.append(n + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
