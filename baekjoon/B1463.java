package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1] = 0;
            } else if (i == 2) {
                dp[2] = 1;
            } else if (i == 3) {
                dp[3] = 1;
            } else {
                int num1 = dp[i - 1];
                int num2 = 999999999;
                int num3 = 999999999;
                if (i % 2 == 0) {
                    num2 = dp[i / 2];
                }
                if (i % 3 == 0) {
                    num3 = dp[i / 3];
                }
                dp[i] = 1 + Math.min(Math.min(num1, num2), num3);
            }
        }
        System.out.println(dp[n]);
    }
}
