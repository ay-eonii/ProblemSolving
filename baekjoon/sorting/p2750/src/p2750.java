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

//        insertSorting(size, n);
        bubbleSorting(size, n);

        for (int i : n) {
            System.out.println(i);
        }
    }

    private static void bubbleSorting(int size, int[] n) {
        for (int i = 0; i < size - 1; i++) {  //52341 25341 23541 23451 23415 / 23145 / 21345 / 12345
            for (int j = 0; j < size - 1; j++) {
                int temp = n[j];
                if (temp > n[j+1]) {
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
            }
        }
    }

    private static void insertSorting(int size, int[] n) {
        for (int i = 1; i < size; i++) {
            int j = i - 1;
            int temp = n[i];
            while (j >= 0 && temp < n[j]) {
                n[j + 1] = n[j];
                j--;
            }
            n[j + 1] = temp;
        }
    }
}