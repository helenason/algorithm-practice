package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            sb.append(calculate(m, n));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static long calculate(int x, int y) {
        long[][] factorials = new long[30][30];

        factorials[x][1] = x;
        for (int i = 2; i <= y; i++) {
            factorials[x][i] = factorials[x][i - 1] * (x - i + 1) / i;
        }

        return factorials[x][y];
    }
}
