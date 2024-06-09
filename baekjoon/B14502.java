package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14502 {

    static int n;
    static int m;
    static int safeArea;
    static String[][] initGraph;
    static String[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        initGraph = new String[n][m];
        graph = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            graph[i] = input2;
            initGraph[i] = input2.clone();
        }

        for (int i1 = 0; i1 < n; i1++) { // 벽 1
            for (int i2 = 0; i2 < m; i2++) {
                for (int j1 = 0; j1 < n; j1++) { // 벽 2
                    for (int j2 = 0; j2 < m; j2++) {
                        for (int k1 = 0; k1 < n; k1++) { // 벽 3
                            for (int k2 = 0; k2 < m; k2++) {
                                if ((i1 == j1 && i2 == j2) || (j1 == k1 && j2 == k2) || (i1 == k1 && i2 == k2)) {
                                    // 서로 다른 세 벽이 아닌 경우
                                    continue;
                                }
                                if (graph[i1][i2].equals("0") && graph[j1][j2].equals("0") && graph[k1][k2].equals("0")) {
                                    graph[i1][i2] = "1";
                                    graph[j1][j2] = "1";
                                    graph[k1][k2] = "1";
                                    int tmp = countSafeArea();
                                    if (safeArea < tmp) {
                                        safeArea = tmp;
                                    }
                                    for (int i = 0; i < n; i++) {
                                        graph[i] = initGraph[i].clone();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(safeArea);
    }

    static int countSafeArea() {
        int count = 0;
        boolean[][] visited = new boolean[n][m];

        // 1. 바이러스 전파시키기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j].equals("2")) {
                    bfs(i, j, visited);
                }
            }
        }

        // 2. 안전 영역 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j].equals("0")) {
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int i, int j, boolean[][] visited) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            for (int z = 0; z < 4; z++) {
                int nx = now.x + dx[z];
                int ny = now.y + dy[z];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || graph[nx][ny].equals("1")) {
                    continue;
                }
                queue.offer(new Position(nx, ny));
                visited[nx][ny] = true;
                graph[nx][ny] = "2";
            }
        }
    }

    static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
