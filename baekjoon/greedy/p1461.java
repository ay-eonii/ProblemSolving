package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] location = new int[n];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            location[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(location);
        int index = 0;
        List<Integer> list = new ArrayList<>();
        while (index < n && location[index] < 0) {
            list.add(-location[index]);
            index += m;
        }

        index = n - 1;
        while (index >= 0 && location[index] > 0) {
            list.add(location[index]);
            index -= m;
        }

        Collections.sort(list);
        int answer = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            answer += list.get(i) * 2;
        }
        answer += list.get(list.size() - 1);

        System.out.println(answer);
    }
}
