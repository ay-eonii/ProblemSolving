/* problem
치킨집의 맛의 수치를 감소하지 않는 순으로 정렬
N개의 치킨의 수치를 무작위로 놓은 뒤 N/2명의 C.T.P 회원이 차례대로 2개의 치킨집을 선택해 정렬을 한다.
그 뒤 N/4명이 차례대로 바로 전 단계의 사람이 정렬한 두 개의 그룹을 차례대로 선택 하여 치킨집을 정렬을 한다.
계속해서 N/8명, N/16명이 정렬을 진행하다가 마지막 사람이 두 개의 정렬된 그룹을 합병하여 작업을 완료한다.
 */

package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11582 {

    private static int[] CHICKENS;
    private static int K;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        CHICKENS = new int[N];
        for (int i = 0; i < N; i++) {
            CHICKENS[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        sort(0, N);

        StringBuilder sb = new StringBuilder();
        for (int chicken : CHICKENS) {
            sb.append(chicken + " ");
        }
        System.out.print(sb);
    }

    private static void sort(int start, int size) {
        if (N / size == K) {
            Arrays.sort(CHICKENS, start, start + size);
            return;
        }

        int newSize = size / 2;
        sort(start, newSize);
        sort(start + newSize, newSize);
    }
}

// strategy
// merge sort
// 현재 단계에서 k명이 정렬
// 사람 수 : N/2 -> N/4 -> N/8 -> N/16

