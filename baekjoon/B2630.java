package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2630 {

    private static List<List<Integer>> colors;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        colors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> tmp = new ArrayList<>();
            while (st.hasMoreTokens()) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }
            colors.add(tmp);
        }

        splitPaper(0, n, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void splitPaper(int x_start, int x_end, int y_start, int y_end) {
        if (checkIfBlue(x_start, x_end, y_start, y_end)) {
            blue += 1;
            return;
        }
        if (checkIfWhite(x_start, x_end, y_start, y_end)) {
            white += 1;
            return;
        }
        int x_mid = (x_start + x_end) / 2;
        int y_mid = (y_start + y_end) / 2;
        splitPaper(x_start, x_mid, y_start, y_mid);
        splitPaper(x_mid, x_end, y_start, y_mid);
        splitPaper(x_start, x_mid, y_mid, y_end);
        splitPaper(x_mid, x_end, y_mid, y_end);
    }

    private static boolean checkIfBlue(int x_start, int x_end, int y_start, int y_end) {
        for (int x = x_start; x < x_end; x++) {
            for (int y = y_start; y < y_end; y++) {
                int color = colors.get(x).get(y);
                if (color != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkIfWhite(int x_start, int x_end, int y_start, int y_end) {
        for (int x = x_start; x < x_end; x++) {
            for (int y = y_start; y < y_end; y++) {
                int color = colors.get(x).get(y);
                if (color != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
