package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String[] rawNumbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }

        int[] dp = new int[n];
        dp[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
        }

        int result = dp[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
