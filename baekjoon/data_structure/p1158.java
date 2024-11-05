package baekjoon.data_structure;

/*
1. 아이디어
- 순서에 맞게 사람 제거
- 빠진 사람은 순서에 포함 x
2. 시간복잡도
3. 자료구조
- LinkedList | Queue
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class p1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        int order = 0;
        List<Integer> answer = new ArrayList<>();
        while (!people.isEmpty()) {
            order = (order + K - 1) % people.size();
            Integer removed = people.remove(order);
            answer.add(removed);
        }

        StringJoiner sj = new StringJoiner(", ", "<", ">");
        for (int i : answer) {
            sj.add(i + "");
        }
        System.out.print(sj);
    }
}
