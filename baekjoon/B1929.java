package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1929 {

    static boolean[] isNotSosu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        isNotSosu = new boolean[n + 1];

        // 2, 3, ... 의 배수들을 `소수가 아님` 처리 해준다.
        isNotSosu[0] = true;
        isNotSosu[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isNotSosu[i]) {
                continue;
            }
            for (int j = i * 2; j <= n; j += i) {
                isNotSosu[j] = true;
            }
        }

        for (int i = m; i < isNotSosu.length; i++) {
            if (!isNotSosu[i]) {
                System.out.println(i);
            }
        }
    }
}
