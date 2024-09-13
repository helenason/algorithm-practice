package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15649 {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]); // 1 ~ 8
        m = Integer.parseInt(inputs[1]); // 1 ~ 8

        func(new boolean[n + 1], m, "");
    }

    static void func(boolean[] visited, int count, String result) {
        if (count == 0) {
            printResult(result);
            return;
        }
        if (count == m) {
            visited = new boolean[n + 1]; // init
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result += i;
            func(visited, count - 1, result);
            visited[i] = false;
            result = result.substring(0, result.length() - 1);
        }
    }

    static void printResult(String result) {
        for (int i = 0; i < result.length(); i++) {
            System.out.print(result.charAt(i) + " ");
        }
        System.out.println();
    }
}
