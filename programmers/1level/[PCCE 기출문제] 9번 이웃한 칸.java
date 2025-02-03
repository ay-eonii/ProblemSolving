import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[] dh = {0, 1, -1, 0};
    private static final int[] dw = {1, 0, 0, -1};

    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int answer = 0;
        String color = board[h][w];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(h, w));

        Point current = queue.poll();

        for (int i = 0; i < 4; i++) {
            int h_check = current.h + dh[i];
            int w_check = current.w + dw[i];

            if (h_check < 0 || h_check >= n || w_check < 0 || w_check >= n) {
                continue;
            }

            if (color.equals(board[h_check][w_check])) {
                answer++;
            }
        }

        return answer;
    }


    private class Point {

        int h;
        int w;

        public Point(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}

// 2차원, 상하좌우 같은 색 칸의 개수 구하기
