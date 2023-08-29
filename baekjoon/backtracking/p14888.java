package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14888 {
    private static final int[] operator = new int[4];
    private static int N;
    private static int[] operands;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        operands = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(operands[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0 -> dfs(num + operands[idx], idx + 1);
                    case 1 -> dfs(num - operands[idx], idx + 1);
                    case 2 -> dfs(num * operands[idx], idx + 1);
                    case 3 -> dfs(num / operands[idx], idx + 1);
                }

                operator[i]++;
            }
        }
    }
}

/*
1. 재귀
2. 연산자 수 배열에 담아 사용하기
3. 종료조건: 피연산자 모두 계산했을 때
4. min, max 판별
 */
