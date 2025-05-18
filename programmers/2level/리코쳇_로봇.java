import java.util.LinkedList;
import java.util.Queue;

class 리코쳇_로봇 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        Point start = null;
        char[][] game = new char[n][m];
        for (int i = 0; i < n; i++) { // 행
            game[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) { // 열
                if (game[i][j] == 'R') {
                    start = new Point(j, i, 0);
                }
            }
        }

        return bfs(start, n, m, game);
    }

    public int bfs(Point start, int n, int m, char[][] game) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (game[ny][nx] == 'D') {
                        break;
                    }
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                if (visited[ny][nx]) {
                    continue;
                }

                if (game[ny][nx] == 'G') {
                    return cur.count + 1;
                }

                visited[ny][nx] = true;
                queue.add(new Point(nx, ny, cur.count + 1));
            }
        }

        return -1;
    }

    class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
