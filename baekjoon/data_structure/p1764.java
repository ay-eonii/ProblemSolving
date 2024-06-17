/* problem
듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
 */

package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (String l : list) {
            sb.append(l).append("\n");
        }

        System.out.print(sb);
    }
}

// strategy
// hash
