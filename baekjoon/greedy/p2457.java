package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] flowers = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            flowers[i][0] = Integer.parseInt(inputs[0]);
            flowers[i][1] = Integer.parseInt(inputs[1]);
            flowers[i][2] = Integer.parseInt(inputs[2]);
            flowers[i][3] = Integer.parseInt(inputs[3]);
        }

        Arrays.sort(flowers, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        if ((flowers[0][0] > 3) || (flowers[0][0] == 3 && flowers[0][1] > 1)) {
            System.out.println("0");
            return;
        }

        int eMonth = 3;
        int eDay = 1;
        int sMonth = 3;
        int sDay = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isEndBefore(3, 1, flowers[i])) {
                continue;
            }

            if (isStartAfter(eMonth, eDay, flowers[i])) {
                continue;
            }

            if (eMonth > 11) {
                continue;
            }

            if ((eMonth < flowers[i][2]) || (eMonth == flowers[i][2] && eDay < flowers[i][3])) {
                if (!contains(sMonth, sDay, flowers, i) || (sMonth == eMonth && sDay == eDay)) {
                    count++;
                    sMonth = eMonth;
                    sDay = eDay;
                }

                eMonth = flowers[i][2];
                eDay = flowers[i][3];
            }
        }

        if ((eMonth < 11) || (eMonth == 11 && eDay <= 30)) {
            System.out.println("0");
        } else {
            System.out.println(count);
        }
    }

    private static boolean isEndBefore(int eMonth, int eDay, int[] flowers) {
        return (flowers[2] < eMonth) || ((flowers[2] == eMonth) && flowers[3] <= eDay);
    }

    private static boolean isStartAfter(int eMonth, int eDay, int[] flowers) {
        return (eMonth < flowers[0]) || (eMonth == flowers[0] && eDay < flowers[1]);
    }

    private static boolean contains(int sMonth, int sDay, int[][] flowers, int i) {
        return ((sMonth > flowers[i][0]) || (sMonth == flowers[i][0] && sDay >= flowers[i][1]))
                && (((sMonth < flowers[i][2]) || (sMonth == flowers[i][2] && sDay <= flowers[i][3])));
    }
}
