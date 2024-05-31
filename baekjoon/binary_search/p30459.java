package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p30459 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] locations = new int[n];
        for (int i = 0; i < n; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[m];
        for (int i = 0; i < m; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(locations);
        Arrays.sort(heights);

        double answer = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int distance = locations[i] - locations[j];

                int min = 0;
                int max = m - 1;
                while (min <= max) {
                    int mid = (min + max) / 2;
                    double flag = distance * heights[mid] / 2.0;
                    if (flag > r) {
                        max = mid - 1;
                    } else {
                        answer = Math.max(flag, answer);
                        min = mid + 1;
                    }
                }
            }
        }

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.printf("%.1f", answer);
        }
    }
}

// strategy
// 10 * 2 / 2 = 10
// 10 * 6 / 2 = 30
// 5 * 6 / 2 = 15
// 5 * 8 / 2 = 20
// 말뚝간 길이 구하기
// 조합 -> 3C2 = 3
// 4,000,000
// 1 4 7 10
// 완전 탐색??
