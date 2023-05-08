package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p24060 {

    private static int[] temp;
    private static int saveCnt;
    private static int[] input;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[2];
        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[input[0]];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        saveCnt = 0;
        temp = new int[input[0]];
        mergeSort(0, input[0] - 1);

        if (saveCnt < input[1]) {
            System.out.println(-1);
        }
    }

    private static void mergeSort(int p, int r) {
        if (saveCnt > input[1]) return;
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    private static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            temp[t++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= q) {
            temp[t++] = arr[i++];
        }
        while (j <= r) {
            temp[t++] = arr[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            saveCnt++;
            if (saveCnt == input[1]) {
                System.out.println(temp[t]);
                break;
            }
            arr[i++] = temp[t++];
        }
    }
}
