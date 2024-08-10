package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14627 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sc = br.readLine().split(" ");
        int s = Integer.parseInt(sc[0]);
        int c = Integer.parseInt(sc[1]);
        long[] pas = new long[s];
        long max = -1;
        for (int i = 0; i < s; i++) {
            pas[i] = Integer.parseInt(br.readLine());
            max = Math.max(pas[i], max);
        }

        long left = 1;
        long right = max;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (long pa : pas) {
                count += pa / mid;
            }

            if (count < c) {
                right = mid - 1;
            } else { // count >= c
                result = mid;
                left = mid + 1;
            }
        }

        long sum = 0; // 전체 파 길이
        for (long pa : pas) {
            sum += pa;
        }
        System.out.println(sum - result * c);
    }
}
