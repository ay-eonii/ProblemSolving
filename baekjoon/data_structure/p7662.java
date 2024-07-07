package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class p7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                String[] command = br.readLine().split(" ");
                int key = Integer.parseInt(command[1]);
                if ("I".equals(command[0])) {
                    treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) {
                        continue;
                    }
                    int n = (key == 1) ? treeMap.lastKey() : treeMap.firstKey();
                    if (treeMap.get(n) == 1) {
                        treeMap.remove(n);
                    } else {
                        treeMap.computeIfPresent(n, (ke, v) -> v - 1);
                    }
                }
            }

            if (treeMap.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

// strategy
// 이중 우선순위 큐
// ‘D 1’는 Q에서 최댓값을 삭제
// ‘D -1’는 Q 에서 최솟값을 삭제

// TreeMap
