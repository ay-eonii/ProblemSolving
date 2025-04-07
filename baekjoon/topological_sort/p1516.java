package baekjoon.topological_sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p1516 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int n = scanner.nextInt();

        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        int[] times = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int time = scanner.nextInt();
            times[i] = time;

            int p;
            while ((p = scanner.nextInt()) != -1) {
                indegree[i]++;
                a.get(p).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : a.get(now)) {
                indegree[next]--;

                result[next] = Math.max(result[next], result[now] + times[now]);

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i] + times[i]).append("\n");
        }

        System.out.print(sb);
    }
}
