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
        int sum = 0;
        while (right < n) {
            if (right < left) {
                right = left; // init
                sum = 0; // init
                continue;
            }
            if (sum + nums[right] < m) {
                sum += nums[right];
                result = Math.max(sum, result);
                right++;
            } else if (sum + nums[right] > m) {
                sum -= nums[left];
                left++;
            } else { // sum + nums[right] == m
                sum += nums[right];
                result = Math.max(sum, result);
                break;
            }
        }
        System.out.println(result);
    }
}
