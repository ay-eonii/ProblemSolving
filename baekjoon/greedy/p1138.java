package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] left = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(inputs[i]);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int tall = i + 1;
            int location = left[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (count == location) {
                    location = j;
                    break;
                }
                if (answer[j] == 0) {
                    count++;
                }
            }
            while (answer[location] != 0) {
                location++;
            }
            answer[location] = tall;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}

// 1 2 3 4
// 2 1 1 0
// 234 34 4 0
// 4 2 1 3
// 1 -> 앞에 큰사람 두명 -> 모든 사람이 1보다 크니 무조건 3번째
// 2 -> 앞에 큰사람 1명 -> 모든 사람이 2보다 크니 무조건 2번째
// 3 -> 앞에 큰사람 1명 -> 모든 사람이 3보다 크니 무조건 2번째 -> 자리없음 -> 뒤로
// 4 -> 앞에 큰사람 0명 -> 남는 곳
//6 2 3 4 7 5 1
// 6 2 3 7 5 4 1

//7
//6 1 1 3 2 0 0
