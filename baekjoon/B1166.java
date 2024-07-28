package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1166 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long target = Integer.parseInt(input[0]);
        long l = Integer.parseInt(input[1]);
        long w = Integer.parseInt(input[2]);
        long h = Integer.parseInt(input[3]);

        double left = 0;
        double right = Math.min(Math.min(l, w), h);
        double result = 0;

        while (left <= right) {
            double mid = (left + right) / 2;

            if ((long) (l / mid) * (long) (w / mid) * (long) (h / mid) < target) {
                if (right == mid) {
                    break;
                }
                right = mid;
            } else { // (target <= tmp): 답이 될 수 있는 경우이지만 mid의 최댓값을 찾기 위함
                if (left == mid) {
                    result = mid;
                    break;
                }
                left = mid;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
