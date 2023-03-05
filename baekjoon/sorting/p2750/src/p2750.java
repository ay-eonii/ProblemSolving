import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2750 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        int[] n = new int[size];

        for (int i = 0; i < size; i++) {
            n[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 1; i < size; i++) {
            int j = i - 1;
            int temp = n[i];
            while (j >= 0 && temp < n[j]) {
                n[j + 1] = n[j];
                j--;
            }
            n[j + 1] = temp;
        }
        for (int i : n) {
            System.out.println(i);
        }
    }
}