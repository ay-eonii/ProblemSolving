import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        List<Integer> pNums = new LinkedList<>();
        List<Integer> nNums = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            if (input > 0) {
                pNums.add(input);
            } else {
                nNums.add(input);
            }
        }

        radixSorting(pNums);
        radixSorting(nNums);

        for (int i = nNums.size() - 1; i >= 0; i--) {
            sb.append(nNums.get(i)).append("\n");
        }
        for (Integer pNum : pNums) {
            sb.append(pNum).append("\n");
        }

        System.out.println(sb);
    }

    private static void radixSorting(List<Integer> nums) {
        ArrayDeque<Integer>[] buckets = new ArrayDeque[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayDeque<>();
        }
        int div = 1;
        while (div <= 10000) {
            for (int i = 0; i < nums.size(); i++) {
                buckets[(Math.abs(nums.get(i)) / div) % 10].offer(nums.get(i));
            }
            nums.clear();
            for (int i = 0, j = 0; i < 10; i++) {
                while (!buckets[i].isEmpty()) {
                    nums.add(buckets[i].poll());
                }
            }
            div *= 10;
        }
        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}

class p2108_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        int a = 0; // 산술평균
        int b = 0; // 중앙값
        int c = 0; // 최빈값
        int d = 0; // 범위

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        a = (int) Math.round(((double) sum / n));

        Arrays.sort(arr);
        b = arr[n / 2];

        int[] plus = new int[4002];
        int[] minus = new int[4001];
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                minus[Math.abs(arr[i])]++;
            } else {
                plus[arr[i]]++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < plus.length; i++) {
            max = Math.max(max, plus[i]);

        }
        for (int i = 0; i < minus.length; i++) {
            max = Math.max(max, minus[i]);
        }

        for (int i : arr) {
            if (i < 0) {
                if (minus[Math.abs(i)] == max && !(list.contains(i))) {
                    list.add(i);
                }
            } else {
                if (plus[i] == max && !(list.contains(i))) {
                    list.add(i);
                }
            }
        }

        if (list.size() >= 2) {
            c = list.get(1);
        } else {
            c = list.get(0);
        }

        d = arr[n - 1] - arr[0];

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        in.close();
    }
}


class p2108_v3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        int[] nums = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        Arrays.sort(nums);

        int[] plus = new int[4001];
        int[] minus = new int[4001];
        for (int i = 0; i < size; i++) {
            if (nums[i] > 0) {
                plus[nums[i]]++;
            } else {
                minus[Math.abs(nums[i])]++;
            }
        }
        int max = 0;
        for (int i = 0; i < plus.length; i++) {
            max = Math.max(max, plus[i]);

        }
        for (int i = 0; i < minus.length; i++) {
            max = Math.max(max, minus[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (i < 0) {
                if (minus[Math.abs(i)] == max && !(list.contains(i))) {
                    list.add(i);
                }
            } else {
                if (plus[i] == max && !(list.contains(i))) {
                    list.add(i);
                }
            }
        }

        int mode;
        if (list.size() >= 2) {
            mode = list.get(1);
        } else {
            mode = list.get(0);
        }

        if (sum > 0) {
            System.out.println(sum / size);
        } else {
            System.out.println(sum / size - 1);
        }
        System.out.println(nums[size / 2]);
        System.out.println(mode);
        System.out.println(nums[size - 1] - nums[0]);

    }
}
