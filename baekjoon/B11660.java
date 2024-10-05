package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11660 {

    static int[][] graph;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]); // 1 ≤ n ≤ 1024
        int m = Integer.parseInt(nm[1]); // 1 ≤ m ≤ 100,000
        graph = new int[n + 1][n + 1];
        sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) { // 그래프 입력
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(row[j - 1]);
            }
        }

        // sum 채우기
        for (int i = 1; i < n + 1; i++) { // n
            for (int j = 1; j < n + 1; j++) { // n
                sum[i][j] = graph[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) { // m
            String[] input = br.readLine().split(" "); // 타겟 입력
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int result = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];

            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
