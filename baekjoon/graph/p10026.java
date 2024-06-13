package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p10026 {
    private static final int[] dx = {0, 0, -1, 1};// 상하좌우
    private static final int[] dy = {1, -1, 0, 0};// 상하좌우
    private static String[][] COLORS;
    private static boolean[][] NORMAL_VISITED;
    private static boolean[][] BLIND_VISITED;
    private static int N;
    private static int NORMAL_ANSWER = 0;
    private static int BLIND_ANSWER = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        COLORS = new String[N][N];
        for (int y = 0; y < N; y++) {
            String[] rgb = br.readLine().split("");
            if (N >= 0) System.arraycopy(rgb, 0, COLORS[y], 0, N);
        }

        NORMAL_VISITED = new boolean[N][N];
        BLIND_VISITED = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!NORMAL_VISITED[y][x]) {
                    normalBfs(new Location(x, y));
                }
                if (!BLIND_VISITED[y][x]) {
                    blindBfs(new Location(x, y));
                }
            }
        }

        System.out.println(NORMAL_ANSWER + " " + BLIND_ANSWER);
    }

    private static void normalBfs(Location location) {
        Queue<Location> locations = new LinkedList<>();
        locations.add(location);
        NORMAL_VISITED[location.y][location.x] = true;

        while (!locations.isEmpty()) {
            Location current = locations.poll();
            String color = COLORS[current.y][current.x];

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (color.equals(COLORS[ny][nx]) && !NORMAL_VISITED[ny][nx]) {
                        locations.add(new Location(nx, ny));
                        NORMAL_VISITED[ny][nx] = true;
                    }
                }
            }
        }
        NORMAL_ANSWER++;
    }

    private static void blindBfs(Location location) {
        Queue<Location> locations = new LinkedList<>();
        locations.add(location);
        BLIND_VISITED[location.y][location.x] = true;

        while (!locations.isEmpty()) {
            Location current = locations.poll();
            String color = COLORS[current.y][current.x];

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (isSameArea(color, ny, nx) && !BLIND_VISITED[ny][nx]) {
                        locations.add(new Location(nx, ny));
                        BLIND_VISITED[ny][nx] = true;
                    }
                }
            }
        }
        BLIND_ANSWER++;
    }

    private static boolean isSameArea(String color, int ny, int nx) {
        if (color.equals(COLORS[ny][nx])) {
            return true;
        }
        if (color.equals("R")) {
            return COLORS[ny][nx].equals("G");
        }
        if (color.equals("G")) {
            return COLORS[ny][nx].equals("R");
        }
        return false;
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
// 적록색약 : 빨간색 == 초록색
// bfs
// queue 빌때마다 count++
