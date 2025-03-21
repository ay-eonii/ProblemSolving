package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int d = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        int c = Integer.parseInt(inputs[3]);

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(sushi[i]);
            count[sushi[i]]++;
        }
        set.add(c);

        int max = set.size();
        int left = 0;
        int right = k - 1;
        while (left < n) {
            int exclude = sushi[left];
            count[exclude]--;
            if (count[exclude] == 0) {
                set.remove(exclude);
            }

            left++;
            right = (right + 1) % n;

            int include = sushi[right];
            count[include]++;
            set.add(include);
            set.add(c);

            max = Math.max(set.size(), max);
        }

        System.out.println(max);
    }
}
