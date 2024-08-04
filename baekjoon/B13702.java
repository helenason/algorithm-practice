package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        long[] kettles = new long[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            int amount = Integer.parseInt(br.readLine());
            max = Math.max(max, amount);
            kettles[i] = amount;
        }

        long left = 1;
        long right = max;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            long tmp = 0;
            for (long kettle : kettles) {
                tmp += (kettle / mid);
            }

            if (tmp >= k) {
                left = mid + 1;
                result = mid;
            } else { // tmp < k
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
