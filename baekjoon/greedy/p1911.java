package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p1911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int l = Integer.parseInt(inputs[1]);

        long[][] ponds = new long[n][2];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            ponds[i][0] = Long.parseLong(inputs[0]);
            ponds[i][1] = Long.parseLong(inputs[1]);
        }

        Arrays.sort(ponds, Comparator.comparingLong(value -> value[0]));

        long count = 0;
        long prev = ponds[0][0] - 1;
        for (int i = 0; i < n; i++) {
            long curStart = ponds[i][0];
            long curEnd = ponds[i][1];

            if (prev >= curEnd) {
                continue;
            }

            if (prev >= curStart) {
                curStart = prev + 1;
            }

            long used = (curEnd - curStart) / l;
            long remain = (curEnd - curStart) % l;

            count += used;
            prev = curStart + (used * l) - 1;

            if (remain != 0) {
                count++;
                prev += l;
            }
        }

        System.out.println(count);
    }
}
