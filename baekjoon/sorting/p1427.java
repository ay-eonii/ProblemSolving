package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();

        String[] strArr = num.split("");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        shellSorting(numArr);

        for (int n : numArr) {
            sb.append(n);
        }

        System.out.println(sb);
    }

    private static void shellSorting(int[] numArr) {
        for (int h = numArr.length / 2; h > 0; h /= 2) { // 간격
            for (int i = h; i < numArr.length; i++) { // 뒷 그룹
                int j;
                int temp = numArr[i];

                for (j = i - h; j >= 0 && numArr[j] < temp; j -= h) { // 앞 그룹(j) = 뒷그룹(i) - 간격(h) vs 뒷 그룹(i)
                    numArr[j + h] = numArr[j];
                }
                numArr[j + h] = temp;
            }
        }
    }
}
