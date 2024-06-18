package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1697 {
    private static int[] visited;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        if (n >= K) {
            System.out.print(n - K);
            return;
        }

        visited = new int[100_001];
        bfs(n);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = poll + 1;
                } else if (i == 1) {
                    next = poll - 1;
                } else {
                    next = poll * 2;
                }

                if (next == K) {
                    System.out.print(visited[poll]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[poll] + 1;
                }
            }
        }
    }

}

// strategy
// 수빈 N
// 동생 K
// 걷기 : X-1 || X+1
// 순간이동 : 2*X
// 수빈이가 동생 찾는 가장 빠른 시간
// dp
// min(arr[i-1], arr[i/2] + 1, arr[i+1])
// if (arr[i/2] % 2 != 0) ? +1

// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
// 2 1 0 1 1 2 2 3 2 3 3  4  3  4  4  4  3  4
