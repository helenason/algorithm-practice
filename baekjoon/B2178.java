package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2178 {

    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = br.read() - 48;
            }
            br.read();
        }
        bfs();
        System.out.println(graph[n - 1][m - 1]);
    }

    static void bfs() {
        List<Position> queue = new ArrayList<>();
        queue.add(new Position(0, 0));
        while (!queue.isEmpty()) {
            Position now = queue.remove(0);
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && graph[nx][ny] == 1) {
                    queue.add(new Position(nx, ny));
                    graph[nx][ny] = graph[now.x][now.y] + 1;
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
