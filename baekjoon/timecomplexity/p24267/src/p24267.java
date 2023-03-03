package baekjoon.timecomplexity.p24267.src;

import java.util.Scanner;

public class p24267 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        System.out.println(n * (n - 1) * (n - 2) / 6);
        System.out.println("3");
        scanner.close();
    }
}
