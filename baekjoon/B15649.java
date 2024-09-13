package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15649 {

    static int n;
    static int m;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]); // 1 ~ 8
        m = Integer.parseInt(inputs[1]); // 1 ~ 8

        func(m);
    }

    static void func(int count) {
        if (count == 0) {
            printResult(result);
            return;
        }
        if (count == m) {
            visited = new boolean[n + 1]; // init
            result = new int[m + 1];
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[m - count + 1] = i;
            func(count - 1);
            visited[i] = false;
        }
    }

    static void printResult(int[] result) {
        for (int i = 1; i <= m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
