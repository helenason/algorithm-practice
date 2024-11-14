package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1226 {

    static String[][] graph = new String[16][16];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 0;
        while (t < 10) {
            t = Integer.parseInt(br.readLine());
            for (int i = 0; i < 16; i++) {
                String row = br.readLine();
                for (int j = 0; j < 16; j++) {
                    graph[i][j] = String.valueOf(row.charAt(j));
                }
            }

            sb.append("#");
            sb.append(t);
            sb.append(" ");
            sb.append(bfs(1, 1));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static String bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            if (graph[now.x][now.y].equals("3")) {
                return "1";
            }
            graph[now.x][now.y] = "1";
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (graph[nx][ny].equals("1")) {
                    continue;
                }
                queue.add(new Position(nx, ny));
            }
        }
        return "0";
    }

    static class Position {

        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
    static String dfs(int x, int y) {
        graph[x][y] = "4"; // visit
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (graph[nx][ny].equals("3")) {
                return "1";
            }
            if (graph[nx][ny].equals("4") || graph[nx][ny].equals("1")) {
                continue;
            }
            if (dfs(nx, ny).equals("1")) {
                return "1";
            }
        }
        return "0";
    }
     */
}
