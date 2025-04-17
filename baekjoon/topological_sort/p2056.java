package baekjoon.topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p2056 {

    private static int n;
    private static List<Integer>[] arr;
    private static int[] indegree;
    private static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        indegree = new int[n + 1];
        time = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
            String[] inputs = br.readLine().split(" ", 3);
            time[i] = Integer.parseInt(inputs[0]);
            if ("0".equals(inputs[1])) {
                continue;
            }

            for (String before : inputs[2].split(" ")) {
                int b = Integer.parseInt(before);
                arr[b].add(i);
                indegree[i]++;
            }
        }

        int[] answer = topologicalSort();
        Arrays.sort(answer);

        System.out.println(answer[n]);
    }

    private static int[] topologicalSort() {
        Queue<Integer> q = new PriorityQueue<>();
        int[] answer = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                answer[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            Integer current = q.poll();

            for (Integer next : arr[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
                answer[next] = Math.max(answer[current] + time[next], answer[next]);
            }
        }
        return answer;
    }
}
