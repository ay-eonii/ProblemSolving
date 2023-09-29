package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11401 {
    private static final long P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long number = factorial(N);
        long denom = factorial(K) * factorial(N - K) % P;

        System.out.println(number * pow(denom, P - 2) % P);
    }

    private static long factorial(long l) {
        long fac = 1L;

        while (l > 1) {
            fac = (fac * l) % P;
            l--;
        }
        return fac;
    }

    private static long pow(long base, long expo) {
        if (expo == 1) {
            return base % P;
        }

        long temp = pow(base, expo / 2);
        if (expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }
        return temp * temp % P;
    }
}
/*
1. 이항계수 => n! / (k! * (n-k)!)
2. 모듈러의 분배 법칙 -> 나눗셈에서는 적용안됨
3. 그럼 곱셈으로 바꾸자!
3-1. n! * (k! * (n-k)!)^(-1)
4. 바꿨으면 모듈러 곱셈 분배 법칙을 적용하자
4-1. (n! % p) * [{k! * (n-k)!}^(-1) % p ] % p
5. 페르마의 소정리 => (k! * (n-k)!) 의 역원 구하기
5-2. (k! * (n-k)!)^(-1) == (k! * (n-k)!)^(1000000007-2)
6. 역원 구할때 거듭제곱 구하기
6-1. 분할정복
*/