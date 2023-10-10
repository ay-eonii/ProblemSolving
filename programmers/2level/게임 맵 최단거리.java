/* problem
게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록
solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, -1, 0, 1};
    private int n, m;
    private int[][] visited;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];

        bfs(maps);

        int answer = visited[n - 1][m - 1];
        return (answer == 0) ? -1 : answer;
    }

    private void bfs(int[][] maps) {
        int x = 0;
        int y = 0;
        visited[y][x] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            for (int i = 0; i < 4; i++) {
                int tempX = current[0] + dx[i];
                int tempY = current[1] + dy[i];
                if (!isOpen(tempX, tempY, maps)) {
                    continue;
                }
                visited[tempY][tempX] = visited[current[1]][current[0]] + 1;
                queue.add(new int[]{tempX, tempY});
            }
        }

    }

    private boolean isOpen(int x, int y, int[][] maps) {
        return (x >= 0 && x < m && y >= 0 && y < n && maps[y][x] == 1 && visited[y][x] == 0);
    }
}

// strategy
// dfs
// 지나온 길 제외 동서남북이 벽이라면 return; **맵 벗어나는 경우 예외처리
// n,m 에 도착했다면 min(max, temp);
// 동서남북은 direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
// max == Math.MAX_VALUE ? return -1
// ---- 효율성 실패

// 최단 거리는 bsf.. -> queue