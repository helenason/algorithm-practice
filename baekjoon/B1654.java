package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kn = br.readLine().split(" ");
        int k = Integer.parseInt(kn[0]);
        int n = Integer.parseInt(kn[1]);
        long[] cables = new long[k];
        int maxCable = -1;
        for (int i = 0; i < k; i++) {
            int cable = Integer.parseInt(br.readLine());
            maxCable = Math.max(maxCable, cable);
            cables[i] = cable;
        }

        long left = 1;
        long right = maxCable;

        while (left <= right) {
            long mid = (left + right) / 2;

            // 케이블 개수 구하기
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += (cables[i] / mid);
            }

            if (sum < n) {
                // 원하는 개수보다 적음 -> 길이가 너무 긺 -> 줄이자
                right = mid - 1;
            } else { // [upper bound]
                // 1. 원하는 개수보다 많음 -> 길이가 너무 짧음 -> 늘리자
                // 2. 원하는 개수와 같음 -> 최댓값을 구하기 위해 늘리자
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}
