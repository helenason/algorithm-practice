package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2167 {

    static int[][] graph;
    static int[][] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        graph = new int[n + 1][m + 1];
        sums = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] rawRow = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(rawRow[j - 1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sums[i][j] = graph[i][j] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            sb.append(calculate(x1, y1, x2, y2));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int calculate(int x1, int y1, int x2, int y2) {
        return sums[x2][y2] - sums[x1 - 1][y2] - sums[x2][y1 - 1] + sums[x1 - 1][y1 - 1];
    }
}
