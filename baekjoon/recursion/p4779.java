package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4779 {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        sb = new StringBuilder();

        while ((str = br.readLine()) != null) {
            double N = Math.pow(3, Integer.parseInt(str));

            cantor(N);
            System.out.println(sb);
            sb.delete(0, sb.length());
        }

    }

    public static void cantor(double N) {
        if (N <= 1) {
            sb.append("-");
            return;
        }
        cantor(N / 3);
        sb.append(" ".repeat((int) N / 3));
        cantor(N / 3);
    }
}