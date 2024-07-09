package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        long [][] dp = new long[n][n];
        dp[0][0] = 1;
        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int jump = graph[i][j];
                if (jump == 0) {
                    break outer;
                }
                if (dp[i][j] == 0) {
                    continue;
                }
                if (j + jump < n) {
                    dp[i][j+jump] += dp[i][j];
                }
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
