package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] chess1 = new int[N + 1][M + 1];
        int[][] chess2 = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            String[] color = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    chess1[i][j] = (color[j - 1].equals("B")) ? 0 : 1;
                    chess2[i][j] = (color[j - 1].equals("W")) ? 0 : 1;
                } else {
                    chess1[i][j] = (color[j - 1].equals("W")) ? 0 : 1;
                    chess2[i][j] = (color[j - 1].equals("B")) ? 0 : 1;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                chess1[i][j] += chess1[i][j - 1];
                chess2[i][j] += chess2[i][j - 1];
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                chess1[i][j] += chess1[i - 1][j];
                chess2[i][j] += chess2[i - 1][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - K + 1; i++) {
            for (int j = 0; j < M - K + 1; j++) {
                int temp1 = chess1[i + K][j + K] - chess1[i][j + K] - chess1[i + K][j] + chess1[i][j];
                int temp2 = chess2[i + K][j + K] - chess2[i][j + K] - chess2[i + K][j] + chess2[i][j];
                int temp = Math.min(temp1, temp2);
                min = Math.min(min, temp);
            }
        }

        System.out.println(min);
    }
}

/*
N=행, M=열, K=체스
0. 정상적인 체스판 2가지 먼저 확보 -> (1)검은색 시작, (2)흰색 시작
1. 입력받은 board와 인덱스 값 비교해서 같으면 0, 다르면 1
2. 행 누적합, 열 누적합 구하기(sum[][])
3. 색칠해야 하는 정사각형 개수 = sum[끝행][끝열] - sum[첫행 - 1][끝열] - sum[끝행][첫열 - 1]
4. 맨 왼쪽 위 칸이 될 수 있는(첫행, 첫열) 인덱스 = [0][0] ~ [N-K][M-K]
 *  */
