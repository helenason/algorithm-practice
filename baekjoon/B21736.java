package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B21736 {

    static int n;
    static int m;
    static String[][] graph;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        graph = new String[n][m];
        int start_i = 0;
        int start_j = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (input[j].equals("I")) {
                    start_i = i;
                    start_j = j;
                }
                graph[i][j] = input[j];
            }
        }

        dfs(start_i, start_j);

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    static void dfs(int x, int y) {
        if (graph[x][y].equals("P")) {
            result++;
        }
        graph[x][y] = "X";

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny].equals("X")) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}
