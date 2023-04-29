package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNum = br.readLine().split(" ");
        int[] num = new int[6];
        for (int i = 0; i < 6; i++) {
            num[i] = Integer.parseInt(strNum[i]);
        }

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (num[0] * x + num[1] * y == num[2] && num[3] * x + num[4] * y == num[5]) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }
    }
}
