package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        char[] arr = br.readLine().toCharArray();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 'P') {
                continue;
            }

            for (int j = i - k; j <= i + k; j++) {
                if (j < 0 || j == i || j >= n) {
                    continue;
                }
                if (arr[j] == 'H') {
                    answer++;
                    arr[j] = ' ';
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
