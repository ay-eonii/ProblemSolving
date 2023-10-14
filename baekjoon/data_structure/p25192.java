package baekjoon.data_structure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class p25192 {
    private static String enter = "ENTER";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        Set<String> nameSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String alert = br.readLine();

            if (alert.equals(enter)) {
                nameSet = new HashSet<>();
                continue;
            }
            if (!nameSet.contains(alert)) {
                nameSet.add(alert);
                count++;
            }
        }
        System.out.println(count);
    }
}