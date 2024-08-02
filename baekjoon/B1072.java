package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        long z = (100L * y) / x;

        int left = 0;
        int right = 1000000000;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            long winPercent = ((y + mid) * 100L / (x + mid));

            if (winPercent <= z) {
                left = mid + 1;
            } else { // winPercent > z
                result = mid;
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
