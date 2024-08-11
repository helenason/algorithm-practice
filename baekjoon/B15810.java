package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15810 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long[] times = new long[n];
        long min = 1000001;
        String[] rawTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(rawTimes[i]);
            min = Math.min(min, times[i]);
        }

        long left = 1;
        long right = min * m;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cal = 0;
            for (long time : times) {
                cal += mid / time;
            }

            if (cal >= m) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
