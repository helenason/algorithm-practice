package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[] gwajas = new int[n];
        int max = -1;
        String[] raws = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            gwajas[i] = Integer.parseInt(raws[i]);
            max = Math.max(gwajas[i], max);
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int gwaja : gwajas) {
                count += gwaja / mid;
            }

            if (count >= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
