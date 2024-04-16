package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B24416 {

    private static int countRecursion = 0;
    private static int countDynamic = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        recursion(n);
        dynamic(n);

        System.out.printf("%d %d", countRecursion, countDynamic);
    }

    private static int recursion(int n) {
        if (n == 1 || n == 2) {
            countRecursion++;
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    private static int dynamic(int n) {
        int[] fibonacci = new int[n + 1];
        fibonacci[1] = 1;
        fibonacci[2] = 1;
        for (int i = 3; i <= n; i++) {
            countDynamic++;
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }
}
