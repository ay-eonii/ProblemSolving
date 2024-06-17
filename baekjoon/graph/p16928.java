package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] move = new int[101];
        for (int i = 0; i < n + m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        int[] count = new int[101];

        queue.add(1); // 출발점
        visited[1] = true;
        count[1] = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur == 100) {
                System.out.print(count[cur]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int location = cur + i;
                if (location > 100) {
                    break;
                }
                if (visited[location]) {
                    continue;
                }
                visited[location] = true;

                if (move[location] != 0) { // 사다리 || 뱀
                    if (!visited[move[location]]) {
                        queue.add(move[location]);
                        visited[move[location]] = true;
                        count[move[location]] = count[cur] + 1;
                    }
                } else {
                    queue.add(location);
                    count[location] = count[cur] + 1;
                }
            }
        }
    }
}

// strategy
// 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값
// 사다리 타기
// 가장 멀리 이동할 수 있는 사다리 타기
// 주사위로 갈 수 있는 곳에 사다리 / 뱀 있으면 추가
//
