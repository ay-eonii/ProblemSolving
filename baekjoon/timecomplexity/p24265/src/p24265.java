import java.util.Scanner;

public class p24265 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        System.out.println(n * (n - 1) / 2);
        System.out.println("2");

        scanner.close();
    }
}
