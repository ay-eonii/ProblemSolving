package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] pocketmons = new String[n + 1];
        Map<String, Integer> pocketmonMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String pocketmon = br.readLine();
            pocketmons[i] = pocketmon;
            pocketmonMap.put(pocketmon, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Character.isLetter(s.charAt(0))) {
                sb.append(pocketmonMap.get(s)).append("\n");
            } else {
                sb.append(pocketmons[Integer.parseInt(s)]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
