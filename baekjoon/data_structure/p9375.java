package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] inputs = br.readLine().split(" ");
                clothes.put(inputs[1], clothes.getOrDefault(inputs[1], 0) + 1);
            }

            int answer = 1;
            for (int count : clothes.values()) {
                answer *= count + 1;
            }

            sb.append(answer - 1).append("\n");
        }

        System.out.print(sb);
    }
}

// strategy
// 입고 안입고
// (종류 개수 + 1) 곱
// 아무것도 안입은 경우 - 1
