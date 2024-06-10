package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p1043 {

    private static int[] ROOT;
    private static List<Integer> TRUTH;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int size = Integer.parseInt(inputs[0]);

        if (size == 0) {
            System.out.println(m);
            return;
        }

        TRUTH = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            TRUTH.add(Integer.parseInt(inputs[i]));
        }

        ROOT = new int[n + 1];
        for (int i = 1; i < ROOT.length; i++) {
            ROOT[i] = i;
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            parties.add(new ArrayList<>());
            List<Integer> party = parties.get(i);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            party.add(x);
            for (int j = 1; j < count; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                party.add(y);
            }
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            boolean flag = true;
            for (Integer p : party) {
                int parent = find(ROOT[p]);
                if (TRUTH.contains(parent)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int find(int x) {
        if (ROOT[x] == x) { // 자신이 부모라면
            return x;
        } else {
            return find(ROOT[x]); // 부모의 부모 찾기
        }
    }

    public static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (TRUTH.contains(ry)) { // 알고있는 집합
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }

        ROOT[ry] = rx;
    }
}

// strategy
// n,m <= 50 -> 완전 탐색
// 그래프
// 진실 아는 사람이랑 연결되어 있으면 안됨
