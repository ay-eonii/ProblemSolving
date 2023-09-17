package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] meetings = new int[N][2];

        for (int[] meeting : meetings) {
            st = new StringTokenizer(br.readLine());
            meeting[0] = Integer.parseInt(st.nextToken());
            meeting[1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prevEnd = 0;
        for (int[] meeting : meetings) {
            if (prevEnd <= meeting[0]) {
                prevEnd = meeting[1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

/*
 * 1. meeting[N][2]
 * 2. 종료시간 기준 오름차순 정렬
 * 2-1. 종료시간 같을 경우 시작시간 오름차순 정렬
 * 3. 종료시간 젤 빠른거 선택 , cnt++
 * 4. if (meeting[i][1] <= meeting[i+1][0]) cnt++
 * */
