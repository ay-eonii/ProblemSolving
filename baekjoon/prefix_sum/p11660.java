package baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class p11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] colSum = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                colSum[i][j] = colSum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < M; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            while (x1 <= x2) {
                answer += colSum[x1][y2];
                answer -= colSum[x1][y1];
                x1++;
            }
            bw.append(String.valueOf(answer)).append("\n");
        }
        bw.flush();
        bw.close();
    }
}

/*
1. int[][] sum에 열마다 누적합 저장 (가로로 누적합)
2. y1부터 y2까지 x2열의 값 모두 더하기
3. y1부터 y2까지 x1 - 1열의 값 모두 빼기
=> [y1][x2] + ... + [y2][x2] - [y1][x1] + ... + [y2][x1]
==행 누적합==
1 3 6 10
2 5 9 14
3 7 12 18
4 9 15 22
 *  */
