package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] budget = new int[n];
        int maxBudget = -1;
        String[] rawBudget = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(rawBudget[i]);
            maxBudget = Math.max(budget[i], maxBudget);
        }
        int m = Integer.parseInt(br.readLine());

        int left = 1;
        int right = maxBudget;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int b : budget) {
                sum += Math.min(b, mid);
            }

            if (m < sum) {
                right = mid - 1;
            } else { // m >= sum
                result = mid;
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
