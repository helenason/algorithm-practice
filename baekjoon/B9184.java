package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9184 {

    private static int[][][] cache = new int[21][21][21]; // 배열 사이즈 고정시키기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("-1 -1 -1")) {
                break;
            }
            String[] numbers = input.split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            int c = Integer.parseInt(numbers[2]);

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        // 1
        // 불필요한 메모이제이션 없애기
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 2
        if (cache[a][b][c] != 0) {
            return cache[a][b][c];
        }

        // 3
        if (a < b && b < c) {
            cache[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return cache[a][b][c];
        }
        cache[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return cache[a][b][c];
    }
}
