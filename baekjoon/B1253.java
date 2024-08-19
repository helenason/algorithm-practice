package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1253 {

    static int n;
    static long[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] rawNumbers = br.readLine().split(" ");
        numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }
        Arrays.sort(numbers);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (isGood(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isGood(int targetIndex) {
        long target = numbers[targetIndex];

        int left = 0;
        int right = n - 1;

        while (left < right) {

            if (left == targetIndex) {
                left++;
            }
            if (right == targetIndex) {
                right--;
            }
            if (left >= right) {
                break;
            }

            long sum = numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
