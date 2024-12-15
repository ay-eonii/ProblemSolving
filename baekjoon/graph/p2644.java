package baekjoon.graph;

/*
1. 아이디어
- x, y -> x: 부모:x, 자식: y
- x, y 2차원 배열 저장
- 촌수[x][y] = 촌수[y][x]
- 연결된 사람 Queue에 넣어 탐색
2. 시간복잡도
3. 자료구조
- int[][] 촌수
- boolean[][] visited
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2644 {

    private static int from;
    private static int to;
    private static int n;
    private static int[][] family;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        family = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            family[x][y] = 1;
            family[y][x] = 1;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(to, from, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visited[current.y][current.x] = true;
            for (int i = 1; i <= n; i++) {
                if (current.x == from && family[current.y][current.x] != 0) {
                    System.out.println(current.count);
                    return;
                }

                if (visited[current.x][i]) {
                    continue;
                }

                if (family[current.x][i] != 0) {
                    queue.add(new Node(i, current.x, current.count + 1));
                    family[current.x][i]++;
                }
            }
        }

        System.out.println(-1);
    }

    static class Node {
        int x; //열
        int y; //행
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
