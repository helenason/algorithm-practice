package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    dp[1] = 1;
                } else if (i == 2) {
                    dp[2] = 2;
                } else if (i == 3) {
                    dp[3] = 4;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
            }

            sb.append(dp[n]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
