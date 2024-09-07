package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String rawInput = br.readLine();
            if (rawInput.equals("0 0")) {
                break;
            }
            String[] input = rawInput.split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int result = 0;
            long[] sangs = new long[n];
            for (int i = 0; i < n; i++) {
                sangs[i] = Integer.parseInt(br.readLine());
            }
            long[] suns = new long[m];
            for (int i = 0; i < m; i++) {
                suns[i] = Integer.parseInt(br.readLine());
            }

            for (long sang : sangs) {
                if (exists(sang, suns)) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private static boolean exists(long target, long[] cds) {
        int left = 0;
        int right = cds.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (cds[mid] > target) {
                right = mid - 1;
            } else if (cds[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
