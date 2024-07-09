package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int[] memo = new int[m];
        int answer = 0;
        for (int i = 1; i < m - 1; i++) {
            if (s[i] == 'O' && s[i + 1] == 'I') { // OI 반복
                memo[i + 1] = memo[i - 1] + 1;
                if (memo[i + 1] >= n && s[i + 1 - (2 * n)] == 'I') { // pn 만족 && I로 시작
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}

// strategy
// dp
// p1 = IOI = 3
// p2 = IOIOI = 5
// pn.length = n*2+1
// OOIOIOIOIIOII
// 마지막 확인 -> 있다면 dp[n-1]+1
