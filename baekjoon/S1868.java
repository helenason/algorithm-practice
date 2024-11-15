package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1868 {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int turn = 0;
        while (turn++ < t) {
            int n = Integer.parseInt(br.readLine());
            String[][] graph = new String[n][n];
            int[][] counts = new int[n][n];
            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                for (int j = 0; j < n; j++) {
                    graph[i][j] = String.valueOf(row.charAt(j));
                }
            }

            // 1. counts 배열 만들기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j].equals("*")) {
                        counts[i][j] = -1;
                        continue;
                    }
                    counts[i][j] = calculateCount(graph, i, j);
                }
            }

            // 2. counts 0인 곳 방문
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (counts[i][j] == 0) {
                        bfs(counts, i, j);
                        result++;
                    }
                }
            }

            // 3. 방문되지 않은 counts 마저 방문
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (counts[i][j] == -1) {
                        continue;
                    }
                    bfs(counts, i, j);
                    result++;
                }
            }
            System.out.println("#" + turn + " " + result);
        }
    }

    static void bfs(int[][] counts, int start_x, int start_y) {
        int n = counts.length;

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(start_x, start_y));

        while (!queue.isEmpty()) {
            Position now = queue.poll();
            if (counts[now.x][now.y] != 0) {
                counts[now.x][now.y] = -1; // 방문 처리
                continue;
            }
            counts[now.x][now.y] = -1; // 방문 처리
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (counts[nx][ny] == -1) {
                    continue;
                }
                queue.add(new Position(nx, ny));
            }
        }
    }

    static int calculateCount(String[][] graph, int x, int y) {
        int n = graph.length;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (graph[nx][ny].equals("*")) {
                count++;
            }
        }
        return count;
    }

    static class Position {

        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x=" + x + " y=" + y;
        }
    }

    static void printCounts(int[][] counts) {
        int n = counts.length;
        for (int[] count : counts) {
            for (int j = 0; j < n; j++) {
                System.out.print(count[j]);
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
