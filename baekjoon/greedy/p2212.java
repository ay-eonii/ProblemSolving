package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class p2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 센서
        int K = Integer.parseInt(br.readLine()); // 집중국

        int[] locations = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(locations);

        if (K >= N) {
            System.out.println(0);
            return;
        }

        Integer[] distances = new Integer[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = locations[i + 1] - locations[i];
        }
        Arrays.sort(distances, Collections.reverseOrder());

        int answer = 0;
        for (int i = K - 1; i < N - 1; i++) {
            answer += distances[i];
        }

        System.out.println(answer);
    }
}

// strategy
// N개의 센서
// 최대 K개의 집중국
// N개의 센서가 적어도 하나의 집중국과는 통신
// 각 집중국의 수신 가능 영역의 길이의 합을 최소화
// 좌표에 여러개 있어도 거리 따로 계산 x

// 집중국이 더 많으면 0
// 집중국이 2개면 최대거리 1개 제외가능
// 집중국이 3개면 최대거리 2개 제외가능

