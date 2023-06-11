package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 수업 - 힙 정렬1
public class p24173 {

    private static int N;
    private static int[] A;
    private static int answer = 0;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        heap_sort(A);
        if (answer < K) {
            System.out.println(-1);
        }
    }

    public static void heap_sort(int[] A) {
        build_min_heap(A);
        for (int i = N; i >= 2; i--) {
            swap(1, i);
            heapify(A, 1, i - 1);
        }
    }

    public static void build_min_heap(int[] A) {
        for (int i = N / 2; i >= 1; i--) {
            heapify(A, i, N);
        }
    }

    public static void heapify(int[] A, int k, int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller;
        if (right <= n) {
            smaller = (A[left] < A[right]) ? left : right;
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (A[smaller] < A[k]) {
            swap(k, smaller);
            heapify(A, smaller, n);
        }
    }

    private static void swap(int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
        answer++;
        if (answer == K) {
            if (A[a] < A[b]) {
                System.out.println(A[a] + " " + A[b]);
            } else {
                System.out.println(A[b] + " " + A[a]);
            }
        }
    }
}

