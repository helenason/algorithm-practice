package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2206 {

    static int n;
    static int m;
    static int[][][] graph; // [][][0]: 벽 부수기 전, [][][1]: 벽 부순 후

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String[] graphInput = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j][0] = Integer.parseInt(graphInput[j]);
                graph[i][j][1] = Integer.parseInt(graphInput[j]);
            }
        }

        // ---

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Movement> queue = new LinkedList<>(); // TODO: queue vs list
        queue.offer(new Movement(0, 0, true));
        while (!queue.isEmpty()) {
            Movement now = queue.poll();
            System.out.println(now);
            if (now.x == n - 1 && now.y == m - 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(graph[i][j][0]);
                    }
                    System.out.println();
                }
                System.out.println();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(graph[i][j][1]);
                    }
                    System.out.println();
                }
                int result1 = graph[n - 1][m - 1][0];
                int result2 = graph[n - 1][m - 1][1];
                if (result1 == 0 && result2 != 0) {
                    System.out.println(result2 + 1);
                } else if (result1 != 0 && result2 == 0) {
                    System.out.println(result1 + 1);
                } else {
                    System.out.println(Math.min(result1, result2) + 1);
                }
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (!now.canBreak) { // 부수기 기회 1번 사용한 경우
                    if (graph[nx][ny][1] != 0) {
                        continue;
                    }
                    queue.offer(new Movement(nx, ny, false));
                    graph[nx][ny][1] = graph[now.x][now.y][1] + 1;
                    continue;
                }
                // 부수기 기회 0번 사용한 경우
                if (graph[nx][ny][0] == 1) {
                    queue.offer(new Movement(nx, ny, false));
                    graph[nx][ny][1] = graph[now.x][now.y][0] + 1;
                    continue;
                }
                if (graph[nx][ny][0] == 0) {
                    queue.offer(new Movement(nx, ny, true));
                    graph[nx][ny][0] = graph[now.x][now.y][0] + 1;
                    continue;
                }
            }
        }
        System.out.println(-1);
    }

    static class Movement {
        int x;
        int y;
        boolean canBreak;

        Movement(int x, int y, boolean canBreak) {
            this.x = x;
            this.y = y;
            this.canBreak = canBreak;
        }
    }
}
