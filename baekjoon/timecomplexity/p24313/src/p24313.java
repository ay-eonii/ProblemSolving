package baekjoon.timecomplexity.p24313.src;

import java.util.Scanner;

// public class p24313 {
//     public static void main(String[] args) throws Exception {
//         Scanner scanner = new Scanner(System.in);
//         int a1 = scanner.nextInt();
//         int a0 = scanner.nextInt();
//         int c = scanner.nextInt();
//         int n0 = scanner.nextInt();

//         boolean isON = false;
//         if (a1 < c && a0 / (c - a1) <= n0) {
//             isON = true;
//         }
//         if (a0 <= 0 && a1 == c) {
//             isON = true;
//         }

//         if (isON) {
//             System.out.println(1);
//         } else {
//             System.out.print(0);
//         }
//         scanner.close();
//     }
// }

// fn = a1n + a0
// c, n0

// n0���� ũ�ų� ���� ��� n�� ���� fn <= c * gn�� �����ϳ�?�� ����� ����

// fn =a1, a0�� �־�����
// c, n0�� �־�����

public class p24313 {
    public static void main(String[] args) throws Exception {
        int a1 = 7, a0 = 7, c = 8, n0 = 10;
        boolean isON = true;
        // Scanner scanner = new Scanner(System.in);
        // int a1 = scanner.nextInt();
        // int a0 = scanner.nextInt();
        // int c = scanner.nextInt();
        // int n0 = scanner.nextInt();

        // for (int n = 1; n <= n0 + 1; n++) {
        int fValue = a1 * n0 + a0;
        int compareValue = n0 * c;

        // System.out.println(fValue + " " + compareValue);

        if (fValue <= compareValue && c >= a1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        // scanner.close();
    }
}
