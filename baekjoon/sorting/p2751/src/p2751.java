import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2751 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for (Integer c : list) {
            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}

/* Solution Point
 * Stringbuilder는 String과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라 기존의 데이터에 더하는 방식을 사용하기 때문에 속도도 빠르며 상대적으로 부하가 적다.
 * */

class p2751_v1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < size; i++) {
            System.out.println(queue.poll());
        }
    }
}

class p2751_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        quickSorting(size - 1, 0, nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void quickSorting(int hi, int lo, int[] nums) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(hi, lo, nums);

        if (pivot + 1 < hi) quickSorting(hi, pivot + 1, nums);
        if (pivot - 1 > lo) quickSorting(pivot - 1, lo, nums);
    }

    private static int partition(int hi, int lo, int[] nums) {
        int pivot = nums[(hi + lo) / 2];

        while (hi > lo) {
            while (nums[hi] > pivot) {
                hi--;
            }
            while (nums[lo] <= pivot) {
                lo++;
            }
            if (hi >= lo) {
                swap(hi, lo, nums);
                hi--;
                lo++;
            }
        }

        return lo;
    }

    private static void swap(int hi, int lo, int[] nums) {
        int temp = nums[hi];
        nums[hi] = nums[lo];
        nums[lo] = temp;
    }
}

class p2751_v3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        insertSorting(nums);

        for (int num : nums) {
            System.out.println(num);
        }

    }

    private static void insertSorting(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int temp = nums[i];
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }
}
