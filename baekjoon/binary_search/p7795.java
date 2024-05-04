package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            int[] a = new int[n];
            int[] b = new int[m];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);

            int answer = 0;
            for (int j = n - 1; j >= 0; j--) {
                int min = 0;
                int max = m - 1;
                while (min <= max) {
                    int mid = (min + max) / 2;
                    if (a[j] > b[mid]) {
                        min = mid + 1;
                    } else {
                        max = mid - 1;
                    }
                }
                answer += min;
            }
            System.out.println(answer);
        }
    }
}

// strategy
// 이분탐색 대상 : B 인덱스
// min = 0, max = m - 1
//
