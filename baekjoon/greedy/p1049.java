package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int packageMin = 1_000;
        int singleMin = 1_000;
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            packageMin = Math.min(packageMin, Integer.parseInt(inputs[0]));
            singleMin = Math.min(singleMin, Integer.parseInt(inputs[1]));
        }

        if (packageMin / 6.0 < singleMin) {
            int answer = Math.min(((n / 6) * packageMin) + ((n % 6) * singleMin), ((n / 6) + 1) * packageMin);
            System.out.println(answer);
        } else {
            System.out.println(n * singleMin);
        }
    }
}
