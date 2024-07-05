package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[101];

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }

            sb.append(dp[n]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
