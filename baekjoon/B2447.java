package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2447 {

    private static String[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        stars = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stars[i][j] = "*";
            }
        }
        blank(n / 3);
        for (String[] star : stars) {
            for (String s : star) {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void blank(int n) {
        if (n <= 0) {
            return;
        }
        for (int x = 0; x < stars.length; x++) {
            for (int y = 0; y < stars.length; y++) {
                if ((x / n) % 3 == 1 && (y / n) % 3 == 1) {
                    stars[x][y] = " ";
                }
            }
        }
        blank(n / 3);
    }
}
