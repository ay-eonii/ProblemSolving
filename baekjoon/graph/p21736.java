package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p21736 {

    private static final int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static final int[] dy = {1, -1, 0, 0}; // 상하좌우
    private static int N;
    private static int M;
    private static char[][] CAMPUS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 행
        M = Integer.parseInt(inputs[1]); // 열

        CAMPUS = new char[N][M];
        int doyeonX = 0;
        int doyeonY = 0;
        for (int y = 0; y < N; y++) {
            char[] infos = br.readLine().toCharArray();
            for (int x = 0; x < M; x++) {
                CAMPUS[y][x] = infos[x];
                if ('I' == CAMPUS[y][x]) {
                    doyeonX = x;
                    doyeonY = y;
                }
            }
        }

        bfs(doyeonX, doyeonY);
    }

    private static void bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[y][x] = true;

        int friends = 0;
        while (!queue.isEmpty()) {
            Location current = queue.poll();
            char campus = CAMPUS[current.y][current.x];
            if ('P' == campus) {
                friends++;
            }
            if ('X' == campus) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) {
                    continue;
                }
                queue.add(new Location(nx, ny));
                visited[ny][nx] = true;
            }
        }

        if (friends == 0) {
            System.out.print("TT");
        } else {
            System.out.print(friends);
        }
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// strategy
// bfs

// string[][] campus -> 메모리: 37532KB, 시간: 368ms
// char[][] campus -> 메모리: 66404KKB, 시간: 584ms
