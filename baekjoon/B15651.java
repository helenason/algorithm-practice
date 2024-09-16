package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15651 {

    static int n;
    static int m;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        result = new int[m];

        func(0, sb);
        System.out.println(sb);
    }

    static void func(int depth, StringBuilder sb) {
        if (depth == m) {
            print(sb);
            return;
        }
        for (int i = 1; i <= n; i++) {
            result[depth] = i;
            func(depth + 1, sb);
        }
    }

    static void print(StringBuilder sb) {
        for (int r : result) {
            sb.append(r);
            sb.append(" ");
        }
        sb.append("\n");
    }
}
