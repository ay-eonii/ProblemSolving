/* problem
각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아
제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.
*/

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N - 1];
        int[] node = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }

        int min = node[0];
        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            if (node[i] < min) {
                min = node[i];
            }
            answer += (long) distance[i] * min;
        }

        System.out.println(answer);
    }
}

/* strategy
 * min으로 유가 저장
 * 앞으로 더 저렴한 주유소 있는지 확인
 * 있다면 idx 저장
 * line[idx-1]까지 min * 거리 합
 * min = 더 저렴한 주유소
 * */