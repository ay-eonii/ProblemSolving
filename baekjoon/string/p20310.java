package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();

        int zeroCount = 0;
        int oneCount = 0;
        for (char input : inputs) {
            if (input == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        zeroCount /= 2;
        oneCount /= 2;
        int passOneCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char input : inputs) {
            if (input == '0') {
                if (zeroCount != 0) {
                    stringBuilder.append(input);
                    zeroCount--;
                }
            } else {
                if (passOneCount >= oneCount) {
                    stringBuilder.append(input);
                } else {
                    passOneCount++;
                }
            }
        }

        System.out.println(stringBuilder);
    }
}

// strategy
// 0의 절반
// 1의 절반
// 0은 빠르게
// 1은 느리게
