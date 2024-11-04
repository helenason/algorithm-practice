package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B31785 {

    static int[] a;
    static int[] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        a = new int[500_000];
        sums = new int[500_000];
        int left = 0;
        int right = -1;
        while (q-- > 0) { // 500,000
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            if (num.equals("1")) {
                int x = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
                a[++right] = x; // ?
                if (right == 0) {
                    sums[0] = x;
                } else {
                    sums[right] = sums[right - 1] + x;
                }
            } else { // num.equals("2")
                int mid = (left + right - 1) / 2;

                int sum_left = sums[mid] - (left > 0 ? sums[left - 1] : 0);
                int sum_right = sums[right] - sums[mid];

                if (sum_left <= sum_right) {
                    sb.append(sum_left);
                    sb.append("\n");
                    left = mid + 1;
                } else { // sum_left > sum_right
                    sb.append(sum_right);
                    sb.append("\n");
                    right = mid;
                }
            }
        }

        for (int i = left; i <= right; i++) {
            sb.append(a[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
