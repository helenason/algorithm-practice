package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B27514 {

    static int[] arr = new int[63]; // k: 0 ~ 62

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            long tmp = Long.parseLong(st.nextToken(" "));
            if (tmp == 0) {
                continue;
            }
            int k = (int) (Math.log(tmp) / Math.log(2));
            arr[k]++;
        }

        long resultK = 0;
        for (int k = 1; k < 63; k++) {
            arr[k] += (arr[k - 1] / 2);
            if (arr[k] != 0) {
                resultK = k;
            }
        }
        System.out.println((long) Math.pow(2, resultK));
    }
}
