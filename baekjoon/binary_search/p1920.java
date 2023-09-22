package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1920 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {

            int target = Integer.parseInt(st.nextToken());
            if (find(target)) { // solution1. 반복
//          if (find(0, N - 1, target)) { //solution2. 재귀
                sb.append(1).append("\n");
                continue;
            }
            sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    // solution1. 반복
    private static boolean find(int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            }
            if (arr[mid] == target) {
                return true;
            }
        }
        return false;
    }

    // solution2. 재귀
    private static boolean find(int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] > target) {
                return find(start, mid - 1, target);
            }
            if (arr[mid] < target) {
                return find(mid + 1, end, target);
            }
            return true;
        }
        return false;
    }
}
