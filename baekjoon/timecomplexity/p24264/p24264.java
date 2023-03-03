package baekjoon.timecomplexity.p24264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p24264 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());

        System.out.println(Math.pow(n, 2));
        System.out.println("2");
    }
}
