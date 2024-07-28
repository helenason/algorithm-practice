package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long left = 0;
        long right = n;
        long q = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (Math.pow(mid, 2) >= n) { // 답이 될 수 있지만 최소를 찾자
                q = mid;
                right = mid - 1;
            } else { // mid * mid < n
                left = mid + 1;
            }
        }
        System.out.println(q);
    }
}
