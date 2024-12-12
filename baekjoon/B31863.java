package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B31863 {

    static char[][] graph;
    static boolean[][] visited;
    static int n;
    static int m;
    static int totalBuilding = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        graph = new char[n][m];
        visited = new boolean[n][m];
        int x = -1;
        int y = -1;
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j);
                if (graph[i][j] == '@') { // 진원지
                    x = i;
                    y = j;
                    continue;
                }
                if (graph[i][j] == '*' || graph[i][j] == '#') {
                    totalBuilding++;
                } // 건물 수 세기
            }
        }
        int initBuilding = totalBuilding;

        bfs(x, y);
        System.out.println(initBuilding - totalBuilding + " " + totalBuilding);
    }

    static void bfs(int x, int y) {
        Queue<XY> queue = new LinkedList<>();

        // init
        graph[x][y] = '.'; // @ -> .
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (graph[nx][ny] == '|') { // 방파제
                continue;
            }
            queue.add(new XY(nx, ny));

            int nx2 = x + 2 * dx[i];
            int ny2 = y + 2 * dy[i];
            if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m) {
                continue;
            }
            if (graph[nx2][ny2] == '|') { // 방파제
                continue;
            }
            queue.add(new XY(nx2, ny2));
        }

        // spread
        while (!queue.isEmpty()) {
            XY xy = queue.poll();
            if (graph[xy.x][xy.y] == '.') {
                continue;
            }
            if (graph[xy.x][xy.y] == '*') { // 내진 X
                visited[xy.x][xy.y] = true;
                collapse(xy.x, xy.y, queue);
            } else if (graph[xy.x][xy.y] == '#') { // 내진 O
                if (visited[xy.x][xy.y]) { // 두번째 도달이라면
                    collapse(xy.x, xy.y, queue);
                } else { // 첫번째 도달이라면
                    visited[xy.x][xy.y] = true;
                }
            }
        }
    }

    static void collapse(int x, int y, Queue<XY> queue) {
        graph[x][y] = '.';
        totalBuilding--;
        spread(x, y, queue);
    }

    static void spread(int x, int y, Queue<XY> queue) {
        for (int i = 0; i < 4; i++) { // 상하좌우
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (graph[nx][ny] == '|') { // 방파제
                continue;
            }
            queue.add(new XY(nx, ny));
        }
    }

    static class XY {

        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
