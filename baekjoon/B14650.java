package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14650 {

    static int n;
    static int[] result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 1 ~ 9
        result = new int[n];

        func(0);
        System.out.println(count);
    }

    static void func(int depth) {
        if (depth == n) {
            // 3의 배수이면 count 1 증가
            int sum = 0;
            for (int r : result) {
                sum += r;
            }
            if (sum % 3 == 0) {
                count++;
            }
            return;
        }
        for (int i = 0; i <= 2; i++) { // i: 0 ~ 2
            if (depth == 0 && i == 0) {
                continue;
            }
            result[depth] = i;
            func(depth + 1);
        }
    }
}
