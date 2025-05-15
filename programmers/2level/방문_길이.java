import java.util.Map;

public class 방문_길이 {

    private static final Map<Character, int[]> commands = Map.of(
            'U', new int[]{0, -1},
            'D', new int[]{0, 1},
            'R', new int[]{1, 0},
            'L', new int[]{-1, 0}
    );

    public int solution(String dirs) {

        boolean[][][][] visited = new boolean[11][11][11][11];

        int answer = 0;
        int[] current = new int[]{5, 5};
        for (char dir : dirs.toCharArray()) {
            int[] d = commands.get(dir);
            int cx = current[0];
            int cy = current[1];
            int nx = cx + d[0];
            int ny = cy + d[1];

            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) {
                continue;
            }

            current = new int[]{nx, ny};
            if (visited[cx][cy][nx][ny] || visited[nx][ny][cx][cy]) {
                continue;
            }

            visited[cx][cy][nx][ny] = visited[nx][ny][cx][cy] = true;
            answer++;
        }

        return answer;
    }
}
