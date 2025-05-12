package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class p11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] lectures = new long[n][2];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            lectures[i][0] = Long.parseLong(inputs[0]);
            lectures[i][1] = Long.parseLong(inputs[1]);
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            }
            return Long.compare(o1[0], o2[0]);
        });

        Queue<Long> rooms = new PriorityQueue<>();
        for (long[] lecture : lectures) {
            if (!rooms.isEmpty() && rooms.peek() <= lecture[0]) {
                rooms.poll();
            }
            rooms.add(lecture[1]);
        }

        System.out.println(rooms.size());
    }
}
