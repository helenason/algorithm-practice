package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            int[][] apartment = new int[k + 1][n + 1];
            for (int i = 1; i <= n; i++) { // 0층 초기화
                apartment[0][i] = i;
            }
            for (int i = 1; i <= k; i++) { // 1층 ~ k층
                for (int j = 1; j <= n; j++) { // 1호 ~ n호
                    apartment[i][j] = calculate(apartment, i, j);
                }
            }
            sb.append(apartment[k][n]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int calculate(int[][] apartment, int x, int y) {
        int result = 0;
        for (int yy = 1; yy <= y; yy++) {
            result += apartment[x - 1][yy];
        }
        return result;
    }
}
