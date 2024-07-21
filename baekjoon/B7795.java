package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B7795 {

    static int m;
    static long[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
            String[] raw_a = br.readLine().split(" ");
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(raw_a[i]);
            }
            String[] raw_b = br.readLine().split(" ");
            b = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(raw_b[i]);
            }

            Arrays.sort(b);

            long result = 0;
            for (long target : a) {
                result += count(target);
            }
            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int count(long target) { // 본인(target)보다 작은 수 세기
        int left = 0;
        int right = m - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (b[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            } // 수가 중복일 수 있기 때문에 b[mid] == target 경우는 고려하면 안 됨
        }
        // right - left 사이에 target 존재
        return left;
    }
}
