package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum += nums[i] + nums[j] + nums[k];
                    if (sum <= m && sum > max) {
                        max = sum;
                    }
                    sum = 0;
                }
            }
        }
        System.out.println(max);
    }
}

class p2798_recur {
    private static int[] nums;
    private static boolean[] visited;
    private static int n;
    private static int m;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        combi(3, 0);
        System.out.println(max);
    }

    private static void combi(int r, int start) {
        int sum = 0;
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += nums[i];
                    if (sum > m) {
                        break;
                    }
                }
            }
            max = Math.max(sum, max);
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(r - 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
