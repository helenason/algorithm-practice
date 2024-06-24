package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            dp[i] = 1 + dp[i - sqrt * sqrt];
            while (sqrt-- > 0) { // 가능한 모든 제곱근까지 탐색 후 그 중 최솟값
                dp[i] = Math.min(dp[i], 1 + dp[i - sqrt * sqrt]);
            }
        }
        System.out.println(dp[n]);
    }
}
