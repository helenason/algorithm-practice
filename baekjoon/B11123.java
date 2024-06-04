package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11123 {

    static String[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int round = 0; round < t; round++) {

            String[] hw = br.readLine().split(" ");
            h = Integer.parseInt(hw[0]);
            w = Integer.parseInt(hw[1]);
            graph = new String[h][w];
            for (int i = 0; i < h; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    graph[i][j] = input[j];
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j].equals("#")) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        graph[x][y] = ".";
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= h || ny < 0 || ny >= w || !graph[nx][ny].equals("#")) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}
