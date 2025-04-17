package baekjoon.topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p14567 {

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
        int[] answer = topologicalSort();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static int[] topologicalSort() {
        int[] answer = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                answer[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            Integer current = q.poll();
            for (Integer next : arr[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    answer[next] = answer[current] + 1;
                    q.add(next);
                }
            }
        }

        return answer;
    }
}
