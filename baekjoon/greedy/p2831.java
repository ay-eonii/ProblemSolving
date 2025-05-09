package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p2831 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> tallMen = new ArrayList<>();
        List<Integer> shortMen = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int tall = Integer.parseInt(inputs[i]);
            if (tall < 0) {
                tallMen.add(-tall);
            } else {
                shortMen.add(tall);
            }
        }

        List<Integer> tallWomen = new ArrayList<>();
        List<Integer> shortWomen = new ArrayList<>();
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int tall = Integer.parseInt(inputs[i]);
            if (tall < 0) {
                tallWomen.add(-tall);
            } else {
                shortWomen.add(tall);
            }
        }

        Collections.sort(tallMen);
        Collections.sort(shortMen);
        Collections.sort(tallWomen);
        Collections.sort(shortWomen);

        int count = 0;
        for (int i = 0, j = 0; i < tallMen.size() && j < shortWomen.size(); ) {
            if (tallMen.get(i) > shortWomen.get(j)) {
                count++;
                j++;
            }
            i++;
        }

        for (int i = 0, j = 0; i < shortMen.size() && j < tallWomen.size(); ) {
            if (shortMen.get(i) < tallWomen.get(j)) {
                count++;
                i++;
            }
            j++;
        }
        System.out.println(count);
    }
}

