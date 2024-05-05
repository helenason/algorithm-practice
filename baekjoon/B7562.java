package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B7562 {

    static int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int z = 0; z < n; z++) {
            int l = Integer.parseInt(br.readLine());
            graph = new int[l][l];

            String[] start_input = br.readLine().split(" ");
            int start_x = Integer.parseInt(start_input[0]);
            int start_y = Integer.parseInt(start_input[1]);
            Position start = new Position(start_x, start_y);

            String[] end_input = br.readLine().split(" ");
            int end_x = Integer.parseInt(end_input[0]);
            int end_y = Integer.parseInt(end_input[1]);
            Position end = new Position(end_x, end_y);

            bfs(start, end, l);

            sb.append(graph[end.x][end.y]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(Position start, Position end, int l) {
        List<Position> queue = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Position now = queue.remove(0);
            if (now.x == end.x && now.y == end.y) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < l && ny >= 0 && ny < l && graph[nx][ny] == 0) {
                    queue.add(new Position(nx, ny));
                    graph[nx][ny] = graph[now.x][now.y] + 1;
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
