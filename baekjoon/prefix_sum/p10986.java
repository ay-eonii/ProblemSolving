package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long answer = 0;
        long[] sum = new long[N + 1];
        long[] cnt = new long[M];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (sum[i] == 0) {
                answer++;
            }
            cnt[(int) sum[i]]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                answer += (cnt[i] * (cnt[i] - 1)) / 2;
            }
        }

        System.out.println(answer);
    }
}

/*
 * 1. total 구하기, sum[k] : 누적합 -> 0 인덱스부터 k 인덱스까지
 * 2. 1부터 3까지 누적합 = sum[3] - sum[0]
 * ----------시간초과----------------
 * 3. 0 1 2 3 1 2 <- 입력값
 * 4. 0 1 3 6 7 9 <- 누적합
 * 5. 0 1 0 0 1 0 <- 누적합의 나머지
 * 6. 조합? 같은 거 개수 골라서 조합
 *  */