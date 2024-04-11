package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {

    private static int r;
    private static int c;
    private static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        fillNumber(0, 0, n);
    }

    private static void fillNumber(int x, int y, int n) {
        if (n == 0 && x == r && y == c) {
            System.out.println(num);
            System.exit(0);
        }
        if (n == 0) {
            num += 1;
            return;
        }

        int added = (int) Math.pow(2, n - 1);

        /* 불필요한 재귀를 줄이자!
        fillNumber(x, y, n - 1);
        fillNumber(x, y + added, n - 1);
        fillNumber(x + added, y, n - 1);
        fillNumber(x + added, y + added, n - 1);
         */

        if (isBetween(r, x, x + added) && isBetween(c, y, y + added)) {
            fillNumber(x, y, n - 1);
        } else {
            num += added * added;
        }

        if (isBetween(r, x, x + added) && isBetween(c, y, y + 2 * added)) {
            fillNumber(x, y + added, n - 1);
        } else {
            num += added * added;
        }

        if (isBetween(r, x, x + 2 * added) && isBetween(c, y, y + added)) {
            fillNumber(x + added, y, n - 1);
        } else {
            num += added * added;
        }

        if (isBetween(r, x, x + 2 * added) && isBetween(c, y, y + 2 * added)) {
            fillNumber(x + added, y + added, n - 1);
        } else {
            num += added * added;
        }
    }

    private static boolean isBetween(int num, int a, int b) {
        return num >= a && num <= b;
    }
}
