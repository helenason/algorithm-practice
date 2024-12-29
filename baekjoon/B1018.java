package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1018 {

    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        int min = 999999999;
        for (int end_x = 7; end_x < n; end_x++) {
            for (int end_y = 7; end_y < m; end_y++) {
                min = Math.min(min, countFirstWhite(end_x - 7, end_x, end_y - 7, end_y));
                min = Math.min(min, countFirstBlack(end_x - 7, end_x, end_y - 7, end_y));
            }
        }
        System.out.println(min);
    }

    static int countFirstWhite(int start_x, int end_x, int start_y, int end_y) {
        int result = 0;
        for (int i = start_x; i < end_x + 1; i++) {
            if (i % 2 == 0) { // 0, 2, 4, 6
                for (int j = start_y; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'W') {
                        result++;
                    }
                }
                for (int j = start_y + 1; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'B') {
                        result++;
                    }
                }
            } else { // 1, 3, 5, 7
                for (int j = start_y; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'B') {
                        result++;
                    }
                }
                for (int j = start_y + 1; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'W') {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    static int countFirstBlack(int start_x, int end_x, int start_y, int end_y) {
        int result = 0;
        for (int i = start_x; i < end_x + 1; i++) {
            if (i % 2 == 0) { // 0, 2, 4, 6
                for (int j = start_y; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'B') {
                        result++;
                    }
                }
                for (int j = start_y + 1; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'W') {
                        result++;
                    }
                }
            } else { // 1, 3, 5, 7
                for (int j = start_y; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'W') {
                        result++;
                    }
                }
                for (int j = start_y + 1; j < end_y + 1; j += 2) {
                    if (graph[i][j] != 'B') {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
