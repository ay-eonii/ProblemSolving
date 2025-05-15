import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기 {

    private List<Integer>[] tree;

    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }

        int min = n;
        for (int[] wire : wires) {
            int c = disconnect(n, wire[0], wire[1]);
            min = Math.min(Math.abs(c - (n - c)), min);
        }

        return min;
    }

    private int disconnect(int n, int from, int to) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited[from] = visited[to] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int t : tree[cur]) {
                if (visited[t]) {
                    continue;
                }
                queue.add(t);
                visited[t] = true;
                count++;
            }
        }

        return count;
    }
}
