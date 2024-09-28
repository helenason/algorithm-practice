package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B25916 {

    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        nums = new int[n];
        String[] rawNums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(rawNums[i]);
        }

        int result = 0;

        int left = 0;
        int right = 0;
        int sum = nums[left];
        while (right < n && left < n) {
            if (right < left) {
                right = left; // init
                sum = nums[left];
            }
            if (sum < m) {
                result = Math.max(sum, result);
                right++;
                if (n <= right) {
                    right = n - 1; // wait
                    sum -= nums[left];
                    left++;
                }
                sum += nums[right];
            } else if (sum > m) {
                sum -= nums[left];
                left++;
            } else { // sum == m
                result = Math.max(sum, result);
                break;
            }
        }
        System.out.println(result);
    }
}
