package baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class p16139 {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        int[][] count = new int[26][str.length() + 1];

        for (int col = 0; col < str.length(); col++) {
            for (int row = 0; row < alphabet.length(); row++) {
                count[row][col + 1] = (str.charAt(col) == alphabet.charAt(row)) ? count[row][col] + 1 : count[row][col];
            }
        }

        int questionNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < questionNum; i++) {
            st = new StringTokenizer(br.readLine());
            int row = alphabet.indexOf(st.nextToken());
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            bw.append(String.valueOf(count[row][end] - count[row][start - 1]))
                    .append("\n");
        }
        bw.flush();
        bw.close();
    }
}

/*
1. abcdefghijklmnopqrstuvwxyz길이 & (S 길이 + 1) 배열
2. 첫문자 s: 1열에 기록 -> s행 1열 1;
3. e: 2열에 기록 -> e행 아니면 이전 열 값과 같음. e 행이면 이전 열 값 + 1
4. 구간 누적합 찾을 때는 시작점 = start + 1, 끝점 = end + 1
=> 끝점 열의 찾을문자 행 - (시작점 - 1)열의 찾을문자 행
 *  */
