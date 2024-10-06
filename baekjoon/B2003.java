package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2003 {

    static int[] sums;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        sums = new int[n + 1];
        String[] rawA = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(rawA[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (sums[j] - sums[i - 1] == m) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
