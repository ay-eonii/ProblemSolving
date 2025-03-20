import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 무인도_여행 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private boolean[][] visited;
    private int[][] intMap;
    private int n; //열(x)
    private int m; //행(y)

    public int[] solution(String[] maps) {

        n = maps[0].length();
        m = maps.length;

        intMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] split = maps[i].split("");
            for (int j = 0; j < n; j++) {
                if ("X".equals(split[j])) {
                    intMap[i][j] = 0;
                } else {
                    intMap[i][j] = Integer.parseInt(split[j]);
                }
            }
        }

        visited = new boolean[m][n];
        List<Integer> foods = new ArrayList<>();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (intMap[y][x] == 0 || visited[y][x]) {
                    continue;
                }
                foods.add(bfs(new Point(x, y, intMap[y][x]), intMap));
            }
        }

        if (foods.isEmpty()) {
            return new int[]{-1};
        }
        return foods.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(Point point, int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visited[point.y][point.x] = true;

        int food = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            food += current.food;
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= n || nx < 0 || ny >= m || ny < 0 || visited[ny][nx]) {
                    continue;
                }

                if (maps[ny][nx] == 0) {
                    continue;
                }

                queue.add(new Point(nx, ny, maps[ny][nx]));
                visited[ny][nx] = true;
            }
        }

        return food;
    }

    private class Point {
        int x;
        int y;
        int food;

        public Point(int x, int y, int food) {
            this.x = x;
            this.y = y;
            this.food = food;
        }
    }
}

// bfs
