package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int l = Integer.parseInt(inputs[2]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] rests = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            rests[i] = Integer.parseInt(st.nextToken());
        }

        rests[n + 1] = l;
        Arrays.sort(rests);

        int min = 1;
        int max = l - 1;
        int answer = 0;
        while (min <= max) {
            int count = 0;
            int mid = (min + max) / 2;
            // 휴게소 세우기
            for (int i = 1; i < rests.length; i++) {
                int distance = rests[i] - rests[i - 1];
                count += distance / mid;
                if (distance % mid == 0) {
                    count--;
                }
            }
            if (count > m) { // 많이 세움 -> 간격 늘리기
                min = mid + 1;
            } else {
                answer = mid;
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

// strategy
// 휴게소 위치
// 휴게소 거리
// 82 201 411 555 622 755
