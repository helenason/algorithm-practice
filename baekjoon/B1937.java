package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1937 {

    static int n;
    static int[][] graph;
    static int[][] counts; // 각 지점에서의 maxCount 를 저장하는 그래프
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        counts = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(dfs(i, j), result);
            }
        }
        System.out.println(result);
    }

    static int dfs(int x, int y) {
        if (counts[x][y] != 0) { // 저장되어 있으면 그대로 반환
            return counts[x][y];
        }

        counts[x][y] = 1; // 초깃값

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || graph[x][y] >= graph[nx][ny]) {
                continue;
            }
            counts[x][y] = Math.max(dfs(nx, ny) + 1, counts[x][y]);
        }
        return counts[x][y];
    }
}
