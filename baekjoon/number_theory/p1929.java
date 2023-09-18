package baekjoon.number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            numbers[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (numbers[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                numbers[j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (numbers[i] != 0) {
                sb.append(numbers[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
