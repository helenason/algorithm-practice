package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
            /*
            // 1. 0번째 열
            for (int j = 0; j < 10; j++) {
                dp[i][0] += dp[i - 1][j]; // 윗줄 모든 수의 합
                dp[i][0] %= 10007;
            }
            // 2. 1 ~ 9번째 열
            for (int j = 1; j < 10; j++) {
                // dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1]; // 나머지를 저장하기 때문에 뺄셈은 문제가 될 수 있겠다.
                dp[i][j] %= 10007;
            }
             */
        }

        long result = 0;
        for (int j = 0; j < 10; j++) {
            result += dp[n][j];
        }
        System.out.println(result % 10007);
    }
}
