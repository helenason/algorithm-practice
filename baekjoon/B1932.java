package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                dp[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                    continue;
                }
                if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int[] lastLine = dp[n - 1];
        int max = -1;
        for (int num : lastLine) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
    }
}
