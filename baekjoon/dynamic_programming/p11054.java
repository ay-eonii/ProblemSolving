package baekjoon.dynamic_programming;

/* problem
 * 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11054 {

    private static int[] arr;
    private static Integer[] leftDp;
    private static Integer[] rightDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        leftDp = new Integer[N];
        rightDp = new Integer[N];

        for (int i = 0; i < N; i++) {
            lis(i);
            lds(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(leftDp[i] + rightDp[i], max);
        }
        System.out.println(max - 1);
    }

    private static int lis(int N) {
        if (leftDp[N] == null) {
            leftDp[N] = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    leftDp[N] = Math.max(leftDp[N], lis(i) + 1);
                }
            }
        }
        return leftDp[N];
    }

    private static int lds(int N) {
        if (rightDp[N] == null) {
            rightDp[N] = 1;
            for (int i = N + 1; i < rightDp.length; i++) {
                if (arr[i] < arr[N]) {
                    rightDp[N] = Math.max(rightDp[N], lds(i) + 1);
                }
            }
        }
        return rightDp[N];
    }
}

/* strategy
 * *바이토닉 수열? 어떤 수를 기준으로 증가하다 작아지는 수열
 * ---
 * 1. dp에는 길이를 담자.
 * 2. 왼쪽부터(leftDp) & 오른쪽부터(rightDp) 오름차순
 * 3. 구한 두 배열 합치기
 * -> 해당 index를 기준으로, 왼쪽부터 오름차순 길이 & 오른쪽부터 오름차순 길이가 합해진다!!
 * 4. 근데 여기는 원소 1개씩 중복임 -> 1씩 빼주기
 * 5. 여기서 가장 큰 원소가 최강 길이 부분수열.ㄹ
 * 6. 그럼 1씩 빼주지 않고, 가장 큰 원소 구한 다음 -1 해줘도 될 것.
 * */
