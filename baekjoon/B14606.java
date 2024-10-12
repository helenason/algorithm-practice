package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14606 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = solve(Integer.parseInt(br.readLine()));
        System.out.println(result);
    }

    static int solve(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        arr = new int[n + 1];
        arr[1] = 0;
        arr[2] = 1;
        for (int num = 3; num <= n; num++) {
            int max = -1;
            for (int i = 1; i <= num / 2; i++) {
                max = Math.max(max, (i * (num - i)) + arr[i] + arr[num - i]);
            }
            arr[num] = max;
        }
        return arr[n];
    }
}
