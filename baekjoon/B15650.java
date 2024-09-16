package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650 {

    static int n;
    static int m;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        result = new int[m];

        func(0, 0);
    }

    static void func(int previous, int depth) {
        if (depth == m) {
            print();
            return;
        }
        for (int i = previous + 1; i <= n; i++) {
            result[depth] = i; // 덮어씌워짐
            func(i, depth + 1);
        }
    }

    static void print() {
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
