package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15652 {

    static int n;
    static int m;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        result = new int[m];

        func(1, 0);
        System.out.println(sb);
    }

    static void func(int previous, int depth) {
        if (depth == m) {
            print();
            return;
        }
        for (int i = previous; i <= n; i++) {
            result[depth] = i;
            func(i, depth + 1);
        }
    }

    static void print() {
        for (int r : result) {
            sb.append(r);
            sb.append(" ");
        }
        sb.append("\n");
    }
}
