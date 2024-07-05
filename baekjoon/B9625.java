package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        AB[] dp = new AB[46];

        dp[0] = new AB(1, 0);
        for (int i = 1; i <= k; i++) {
            int prev_a = dp[i-1].a;
            int prev_b = dp[i-1].b;

            int a = prev_b;
            int b = prev_a + prev_b;

            dp[i] = new AB(a, b);
        }

        System.out.println(dp[k].a + " " + dp[k].b);
    }

    static class AB {

        int a;
        int b;

        AB(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
