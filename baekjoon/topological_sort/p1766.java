package baekjoon.topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1766 {

    private static int[] indegree;
    private static List<Integer>[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        arr = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            arr[a].add(b);
            indegree[b]++;
        }

        List<Integer> result = topologicalSort();
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static List<Integer> topologicalSort() {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Integer current = pq.poll();
            result.add(current);

            for (Integer node : arr[current]) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    pq.add(node);
                }
            }
        }

        return result;
    }
}
