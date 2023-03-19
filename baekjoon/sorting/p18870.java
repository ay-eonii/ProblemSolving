package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        int[] sortNums = nums.clone();

        Arrays.sort(nums);

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], cnt++);
        }

        for (int num : sortNums) {
            sb.append(map.get(num) + " ");
        }
        System.out.println(sb);
    }
}
