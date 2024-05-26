package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p8983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        long l = Integer.parseInt(inputs[2]);

        int[] hunters = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hunters[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hunters);

        int[][] animals = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] location = br.readLine().split(" ");
            animals[i][0] = Integer.parseInt(location[0]);
            animals[i][1] = Integer.parseInt(location[1]);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int min = 0;
            int max = m - 1; // 사대 간 거리
            while (min <= max) {
                int mid = (min + max) / 2;
                if (l >= Math.abs(hunters[mid] - animals[i][0]) + animals[i][1]) {
                    answer++;
                    break;
                }
                if (animals[i][0] < hunters[mid]) { // 왼쪽에 더 가까이
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
        }
        System.out.println(answer);
    }
}

// strategy
// 사대 : x
// 동물 : a,b
// 사정거리보다 작거나 같은 위치 사냥 가능
// |x-a|+b
// 이분 탐색: 잡을 수 있냐, 없냐
// 사대끼리의 최소거리 == 사정거리 - 사대끼리 거리/2
// 각 x축마다 사정거리 구하기
// 1 - - 4 - 6 - - 9
// 4 3 3 4 3 4 3 3 4
