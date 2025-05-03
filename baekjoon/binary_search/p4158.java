package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4158 {

    private static int[] a1;
    private static int[] a2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] inputs = input.split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            a1 = new int[n];
            for (int i = 0; i < n; i++) {
                a1[i] = Integer.parseInt(br.readLine());
            }

            a2 = new int[m];
            for (int i = 0; i < m; i++) {
                a2[i] = Integer.parseInt(br.readLine());
            }

            int answer = 0;
            if (n < m) {
                for (int i = 0; i < n; i++) {
                    if (binarySearch(a1[i], a2)) {
                        answer++;
                    }
                }
            } else {
                for (int i = 0; i < m; i++) {
                    if (binarySearch(a2[i], a1)) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

    }

    private static boolean binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
