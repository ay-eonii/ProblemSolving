package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>(new stringComparator());
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (String str : set) {
            sb.append(str + "\n");
        }

        System.out.println(sb);
    }
}

class stringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
            return o1.compareTo(o2);
        } else {
            return o1.length() - o2.length();
        }
    }
}